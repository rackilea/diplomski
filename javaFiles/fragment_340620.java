public class SshClient extends AbstractFactoryManager implements ClientFactoryManager {

    protected IoConnector connector;
    protected SessionFactory sessionFactory;

    private ServerKeyVerifier serverKeyVerifier;

    public SshClient() {
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ServerKeyVerifier getServerKeyVerifier() {
        return serverKeyVerifier;
    }

    public void setServerKeyVerifier(ServerKeyVerifier serverKeyVerifier) {
        this.serverKeyVerifier = serverKeyVerifier;
    }

    public void start() {
        // Register the additional agent forwarding channel if needed
        if (getAgentFactory() != null) {
            List<NamedFactory<Channel>> factories = getChannelFactories();
            if (factories == null) {
                factories = new ArrayList<NamedFactory<Channel>>();
            } else {
                factories = new ArrayList<NamedFactory<Channel>>(factories);
            }
            factories.add(getAgentFactory().getChannelForwardingFactory());
            setChannelFactories(factories);
        }
        connector = createAcceptor();

        if (sessionFactory == null) {
            sessionFactory = new SessionFactory();
        }
        sessionFactory.setClient(this);
        connector.setHandler(sessionFactory);
    }

    protected NioSocketConnector createAcceptor() {
        return new NioSocketConnector(getNioWorkers());
    }

    public void stop() {
        connector.dispose();
        connector = null;
    }

    public ConnectFuture connect(String host, int port) throws Exception {
        assert host != null;
        assert port >= 0;
        if (connector == null) {
            throw new IllegalStateException("SshClient not started. Please call start() method before connecting to a server");
        }
        SocketAddress address = new InetSocketAddress(host, port);
        return connect(address);
    }

    public ConnectFuture connect(SocketAddress address) throws Exception {
        assert address != null;
        if (connector == null) {
            throw new IllegalStateException("SshClient not started. Please call start() method before connecting to a server");
        }
        final ConnectFuture connectFuture = new DefaultConnectFuture(null);
        connector.connect(address).addListener(new IoFutureListener<org.apache.mina.core.future.ConnectFuture>() {
            public void operationComplete(org.apache.mina.core.future.ConnectFuture future) {
                if (future.isCanceled()) {
                    connectFuture.cancel();
                } else if (future.getException() != null) {
                    connectFuture.setException(future.getException());
                } else {
                    ClientSessionImpl session = (ClientSessionImpl) AbstractSession.getSession(future.getSession());
                    connectFuture.setSession(session);
                }
            }
        });
        return connectFuture;
    }

    /**
     * Setup a default client.  The client does not require any additional setup.
     *
     * @return a newly create SSH client
     */
    public static SshClient setUpDefaultClient() {
        SshClient client = new SshClient();
        // DHG14 uses 2048 bits key which are not supported by the default JCE provider
        if (SecurityUtils.isBouncyCastleRegistered()) {
            client.setKeyExchangeFactories(Arrays.<NamedFactory<KeyExchange>>asList(
                    new DHG14.Factory(),
                    new DHG1.Factory()));
            client.setRandomFactory(new SingletonRandomFactory(new BouncyCastleRandom.Factory()));
        } else {
            client.setKeyExchangeFactories(Arrays.<NamedFactory<KeyExchange>>asList(
                    new DHG1.Factory()));
            client.setRandomFactory(new SingletonRandomFactory(new JceRandom.Factory()));
        }
        setUpDefaultCiphers(client);
        // Compression is not enabled by default
        // client.setCompressionFactories(Arrays.<NamedFactory<Compression>>asList(
        //         new CompressionNone.Factory(),
        //         new CompressionZlib.Factory(),
        //         new CompressionDelayedZlib.Factory()));
        client.setCompressionFactories(Arrays.<NamedFactory<Compression>>asList(
                new CompressionNone.Factory()));
        client.setMacFactories(Arrays.<NamedFactory<Mac>>asList(
                new HMACMD5.Factory(),
                new HMACSHA1.Factory(),
                new HMACMD596.Factory(),
                new HMACSHA196.Factory()));
        client.setSignatureFactories(Arrays.<NamedFactory<Signature>>asList(
                new SignatureDSA.Factory(),
                new SignatureRSA.Factory()));
        return client;
    }

    private static void setUpDefaultCiphers(SshClient client) {
        List<NamedFactory<Cipher>> avail = new LinkedList<NamedFactory<Cipher>>();
        avail.add(new AES128CBC.Factory());
        avail.add(new TripleDESCBC.Factory());
        avail.add(new BlowfishCBC.Factory());
        avail.add(new AES192CBC.Factory());
        avail.add(new AES256CBC.Factory());

        for (Iterator<NamedFactory<Cipher>> i = avail.iterator(); i.hasNext();) {
            final NamedFactory<Cipher> f = i.next();
            try {
                final Cipher c = f.create();
                final byte[] key = new byte[c.getBlockSize()];
                final byte[] iv = new byte[c.getIVSize()];
                c.init(Cipher.Mode.Encrypt, key, iv);
            } catch (InvalidKeyException e) {
                i.remove();
            } catch (Exception e) {
                i.remove();
            }
        }
        client.setCipherFactories(avail);
    }

    /*=================================
          Main class implementation
     *=================================*/

    public static void main(String[] args) throws Exception {
        int port = 22;
        String host = null;
        String login = System.getProperty("user.name");
        boolean agentForward = false;
        List<String> command = null;
        int logLevel = 0;
        boolean error = false;

        for (int i = 0; i < args.length; i++) {
            if (command == null && "-p".equals(args[i])) {
                if (i + 1 >= args.length) {
                    System.err.println("option requires an argument: " + args[i]);
                    error = true;
                    break;
                }
                port = Integer.parseInt(args[++i]);
            } else if (command == null && "-l".equals(args[i])) {
                if (i + 1 >= args.length) {
                    System.err.println("option requires an argument: " + args[i]);
                    error = true;
                    break;
                }
                login = args[++i];
            } else if (command == null && "-v".equals(args[i])) {
                logLevel = 1;
            } else if (command == null && "-vv".equals(args[i])) {
                logLevel = 2;
            } else if (command == null && "-vvv".equals(args[i])) {
                logLevel = 3;
            } else if ("-A".equals(args[i])) {
                agentForward = true;
            } else if ("-a".equals(args[i])) {
                agentForward = false;
            } else if (command == null && args[i].startsWith("-")) {
                System.err.println("illegal option: " + args[i]);
                error = true;
                break;
            } else {
                if (host == null) {
                    host = args[i];
                } else {
                    if (command == null) {
                        command = new ArrayList<String>();
                    }
                    command.add(args[i]);
                }
            }
        }
        if (host == null) {
            System.err.println("hostname required");
            error = true;
        }
        if (error) {
            System.err.println("usage: ssh [-A|-a] [-v[v][v]] [-l login] [-p port] hostname [command]");
            System.exit(-1);
        }

        // TODO: handle log level

        SshClient client = SshClient.setUpDefaultClient();
        client.start();

        try {
            boolean hasKeys = false;

            /*
            String authSock = System.getenv(SshAgent.SSH_AUTHSOCKET_ENV_NAME);
            if (authSock == null) {
                KeyPair[] keys = null;
                AgentServer server = new AgentServer();
                authSock = server.start();
                List<String> files = new ArrayList<String>();
                File f = new File(System.getProperty("user.home"), ".ssh/id_dsa");
                if (f.exists() && f.isFile() && f.canRead()) {
                    files.add(f.getAbsolutePath());
                }
                f = new File(System.getProperty("user.home"), ".ssh/id_rsa");
                if (f.exists() && f.isFile() && f.canRead()) {
                    files.add(f.getAbsolutePath());
                }
                try {
                    if (files.size() > 0) {
                        keys = new FileKeyPairProvider(files.toArray(new String[0]), new PasswordFinder() {
                            public char[] getPassword() {
                                try {
                                    System.out.println("Enter password for private key: ");
                                    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
                                    String password = r.readLine();
                                    return password.toCharArray();
                                } catch (IOException e) {
                                    return null;
                                }
                            }
                        }).loadKeys();
                    }
                } catch (Exception e) {
                }
                SshAgent agent = new AgentClient(authSock);
                for (KeyPair key : keys) {
                    agent.addIdentity(key, "");
                }
                agent.close();
            }
            if (authSock != null) {
                SshAgent agent = new AgentClient(authSock);
                hasKeys = agent.getIdentities().size() > 0;
            }
            client.getProperties().put(SshAgent.SSH_AUTHSOCKET_ENV_NAME, authSock);
            */

            ClientSession session = client.connect(host, port).await().getSession();
            int ret = ClientSession.WAIT_AUTH;

            while ((ret & ClientSession.WAIT_AUTH) != 0) {
                if (hasKeys) {
                    session.authAgent(login);
                    ret = session.waitFor(ClientSession.WAIT_AUTH | ClientSession.CLOSED | ClientSession.AUTHED, 0);
                } else {
                    System.out.print("Password:");
                    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
                    String password = r.readLine();
                    session.authPassword(login, password);
                    ret = session.waitFor(ClientSession.WAIT_AUTH | ClientSession.CLOSED | ClientSession.AUTHED, 0);
                }
            }
            if ((ret & ClientSession.CLOSED) != 0) {
                System.err.println("error");
                System.exit(-1);
            }
            ClientChannel channel;
            if (command == null) {
                channel = session.createChannel(ClientChannel.CHANNEL_SHELL);
                ((ChannelShell) channel).setAgentForwarding(agentForward);
                channel.setIn(new NoCloseInputStream(System.in));
            } else {
                channel = session.createChannel(ClientChannel.CHANNEL_EXEC);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                Writer w = new OutputStreamWriter(baos);
                for (String cmd : command) {
                    w.append(cmd).append(" ");
                }
                w.append("\n");
                w.close();
                channel.setIn(new ByteArrayInputStream(baos.toByteArray()));
            }
            channel.setOut(new NoCloseOutputStream(System.out));
            channel.setErr(new NoCloseOutputStream(System.err));
            channel.open().await();
            channel.waitFor(ClientChannel.CLOSED, 0);
            session.close(false);
        } finally {
            client.stop();
        }
    }

}
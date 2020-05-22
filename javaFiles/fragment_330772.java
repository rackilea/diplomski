System.out.println("Connecting to " +IP + "port "
                + Port);

        // load client private key
            KeyStore clientKeys = KeyStore.getInstance("JKS");
            clientKeys.load(
                    new FileInputStream(ProjectConfig
                            .getProperty("KeyStoreAndTrustStore")),
                    ProjectConfig.getProperty(
                            "KeyStoreAndTrustStorePassword")
                            .toCharArray());
            KeyManagerFactory clientKeyManager = KeyManagerFactory
                    .getInstance("SunX509");
            clientKeyManager.init(
                    clientKeys,
                    ProjectConfig.getProperty(
                            "KeyStoreAndTrustStorePassword")
                            .toCharArray());
            // load server public key
            KeyStore serverPub = KeyStore.getInstance("JKS");
            serverPub.load(
                    new FileInputStream(ProjectConfig
                            .getProperty("KeyStoreAndTrustStore")),
                    ProjectConfig.getProperty(
                            "KeyStoreAndTrustStorePassword")
                            .toCharArray());
            TrustManagerFactory trustManager = TrustManagerFactory
                    .getInstance("SunX509");
            trustManager.init(serverPub);

            // use keys to create SSLSoket
            SSLContext ssl = SSLContext.getInstance("TLS");
            ssl.init(clientKeyManager.getKeyManagers(),
                    trustManager.getTrustManagers(),
                    SecureRandom.getInstance("SHA1PRNG"));

            sslClient = (SSLSocket) ssl.getSocketFactory().createSocket(
                    IP, Port);

            sslClient.setSoTimeout(TimeOut);
            System.out.println("connected to "
                    + sslClient.getRemoteSocketAddress());
            OutputStream outToServer = sslClient.getOutputStream();

            out = new DataOutputStream(outToServer);
            String contentToSend = ((String)Paylod);

            out.writeUTF(contentToSend);
            System.out.println(" sending data.... " + contentToSend);
            InputStream inFromServer = sslClient.getInputStream();
            in = new DataInputStream(inFromServer);
            response = in.readUTF();
            System.out.println("Server says.... " + response);
            sslClient.close();
try {

            jsch.addIdentity(privateKeyPath);
            session = jsch.getSession(username, hostL, port);
            session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");

            session.setConfig("StrictHostKeyChecking", "no");



            session.connect();

            session.setPortForwardingL(8080, rHost, rPort);
            Socket s = new Socket();
            s.connect(new InetSocketAddress("localhost", 8080), timeout);


            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
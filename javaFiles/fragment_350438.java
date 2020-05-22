ConnectFuture connectFuture = client.connect(username, host, 22);
        connectFuture.await(5000);

        ClientSession session = connectFuture.getSession();
        session.waitFor(Arrays.asList(ClientSessionEvent.WAIT_AUTH), 5000);

        session.getKex().getServerKey();
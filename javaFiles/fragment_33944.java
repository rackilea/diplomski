SocketChannel channel = createSocketChannel();
SSLEngine sslEngine = createSSLEngine();
doHandShake(sslEngine,channel);


 private void doHandShake(SSLEngine sslEngine, SocketChannel socketChannel) throws Exception {
        System.out.println("Going to do Handshake");

        SSLSession session = sslEngine.getSession();

        ByteBuffer myAppData = ByteBuffer.allocate(session.getApplicationBufferSize());
        ByteBuffer peerAppData = ByteBuffer.allocate(session.getApplicationBufferSize());

        ByteBuffer myNetData = ByteBuffer.allocate(session.getPacketBufferSize());
        ByteBuffer peerNetData = ByteBuffer.allocate(session.getPacketBufferSize());

        sslEngine.beginHandshake();
        SSLEngineResult result;

        handshakeStatus = sslEngine.getHandshakeStatus();

        while (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED &&
                handshakeStatus != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {


            switch (handshakeStatus) {
                case NEED_UNWRAP:
                    if (! (socketChannel.read(peerNetData) <0)) {
                        peerNetData.flip();
                        result = sslEngine.unwrap(peerNetData,peerAppData);
                        peerNetData.compact();

                        handshakeStatus = result.getHandshakeStatus();

                        switch (result.getStatus()) {
                            case OK:
                                break;
                        }

                    }

                    break;
                case NEED_WRAP:
                    myNetData.clear() ;// Empty the local network packet buffer
                    result = sslEngine.wrap(myAppData,myNetData);
                    handshakeStatus = result.getHandshakeStatus();
                    switch (result.getStatus()) {
                        case OK:
                            myNetData.flip();
                            while (myNetData.hasRemaining()) {
                                socketChannel.write(myNetData);
                            }
                    }
                    break;

                case NEED_TASK:
                    Runnable task  = sslEngine.getDelegatedTask();
                    if (null!=task) {
                        task.run();
                    }
                    handshakeStatus = sslEngine.getHandshakeStatus();
                    break;
            }


        }
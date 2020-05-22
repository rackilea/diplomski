packet.setData(
            new byte[receiveBufferSize],
            0,
            receiveBufferSize);
....
localSock.receive(packet); //line 200
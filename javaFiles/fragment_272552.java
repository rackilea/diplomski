while ((input = stdIn.readLine()) != null)
        {
            reqSocket.send(input.getBytes(ZMQ.CHARSET), 0);
            String response = reqSocket.recvStr(0);

            String address = subSocket.recvStr(ZMQ.DONTWAIT);
            String contents = subSocket.recvStr(ZMQ.DONTWAIT);
            System.out.println(           "Notification received: "
                              + address + " : "
                              + contents
                                );
        }
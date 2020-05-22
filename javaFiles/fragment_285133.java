DatagramSocket socket = new DatagramSocket();
            // send request
            byte[] buf = "hi it's Max".getBytes();
            InetAddress address = InetAddress.getByName(host);
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
            socket.send(packet);
            // get response
            buf = new byte[2048];
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            // display response
            buf = packet.getData();
            int len = packet.getLength();
            String received = (new String(buf)).substring(0, len);
            System.out.println("From server: " + received);
            socket.close();
byte[] buf = new byte[1000];
        DatagramPacket recv = new DatagramPacket(buf, buf.length);
        s.send(new DatagramPacket("A".getBytes(), 1, group, port));
        s.receive(recv);

        System.out.println("RECEIVE MODE");
        s.receive(recv);
        System.out.println(MessageFormat.format("Received: {0}",
                new String(recv.getData()).trim()));

        s.leaveGroup(group);
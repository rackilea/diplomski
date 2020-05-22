String data="Hello";
        //get data
        // HERE : first put data in the buffer, THEN build the packet
        byte[] buffer=data.getBytes();

        InetAddress address=InetAddress.getLocalHost();
        System.out.println("Address:"+address);
        DatagramPacket packet=new DatagramPacket(buffer,buffer.length,address,10000);

        //send data
        System.out.println("Sending data");
        socket.send(packet);
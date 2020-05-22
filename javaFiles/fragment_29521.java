while (isRunning()) {
        try {
            byte[] buffer = new byte[256];
            DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(inPacket);
            addPacket(inPacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
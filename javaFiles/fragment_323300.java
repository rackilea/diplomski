try {
        System.out.println("File upload started");
        try (Socket socc = new Socket("localhost", 8117);
                DataOutputStream dos = new DataOutputStream(socc.getOutputStream());
                DataInputStream dis = new DataInputStream(socc.getInputStream())) {
            // send file name
            dos.writeUTF(f.getName());
            // send the file
            Files.copy(f.toPath(), dos);
            dos.flush();
            System.out.println("Data has been sent...waiting for server to respond ");
            // signal to server that sending is finished
            socc.shutdownOutput();
            String RESPONSE = dis.readUTF();
            // this never prints prints
            System.out.println("Server sent: " + RESPONSE);
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
DataInputStream inFromServer = 
            new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
    ...         
        byteSize = (int) Integer.valueOf(response);

        OutputStream fos = new BufferedOutputStream(FileOutputStream(message));
        int total = 0;
        int ch;
        // Continuously writes the file to the disk until complete:
        while (total < byteSize && (ch = inFromServer.read()) != -1) {
            fos.write(ch);
            total ++;
        }
        fos.close();
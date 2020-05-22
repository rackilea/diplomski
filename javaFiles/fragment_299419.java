byteSize = (int) Integer.valueOf(response);
        byte[] byteArray = new byte[4096];
        FileOutputStream fos = new FileOutputStream(message);
        int total = 0;
        // Continuously writes the file to the disk until complete:
        while (total < byteSize && (readBytes = inFromServer.read(byteArray)) != -1) {
            fos.write(byteArray, 0, readBytes);
            total += readBytes;
        }
        fos.close();
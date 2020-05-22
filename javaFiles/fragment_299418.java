byteSize = (int) Integer.valueOf(response);
        byte[] byteArray = new byte[byteSize];
        FileOutputStream fos = new FileOutputStream(message);

        int readBytes = inFromServer.read(byteArray);

        // Continuously writes the file to the disk until complete:
        int total = 0;
        for (int i=0; i<byteArray.length; i++) {
            fos.write(byteArray[i]);
            total++;
        }

        fos.close();
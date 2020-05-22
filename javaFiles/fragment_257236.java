byte [] buffer = new byte[4096];
        int bytesRead;
        int totalLength = 0;

        while(-1 != (bytesRead = is.read(buffer))) {
            bos.write(buffer, 0, bytesRead);
            totalLength += bytesRead;
        }
        bos.close();
        is.close();
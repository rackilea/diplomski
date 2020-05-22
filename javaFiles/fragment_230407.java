InputStream is = socket.getInputStream();
        byte[] buffer = new byte[20000];
        int bytesRead;
        do {
            System.out.println("reading");
            bytesRead = is.read(buffer);
        }
        while (is.available() > 0 && bytesRead != -1);
        System.out.println("socket read");
Socket newCon = ss.accept();
    FileInputStream is = null;
    OutputStream out = null;
    try {
        InputStream sin = newCon.getInputStream();
        DataInputStream sdata = new DataInputStream(sin);
        String location = sdata.readUTF();
        System.out.println("location=" + location);
        File toSend = new File(location);
        // TODO: validate file is safe to access here
        if (!toSend.exists()) {
            System.out.println("File does not exist");
            return;
        }
        is = new FileInputStream(toSend);
        out = newCon.getOutputStream();
        int bytesRead;
        byte[] buffer = new byte[4096];
        while ((bytesRead = is.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        out.flush();
    } finally {
        if (out != null)
            try {
               out.close();
            } catch(IOException e) {
            }
        if (is != null)
            try {
               is.close();
            } catch(IOException e) {
            }
        newCon.close();
    }
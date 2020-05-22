File file = new File(Environment.getExternalStorageDirectory(),"RAHASYA.mp4");
    byte[] bytes = new byte[2048];
    BufferedInputStream bis;
    try {
        bis = new BufferedInputStream(new FileInputStream(file));
        OutputStream os = socket.getOutputStream();
        int read = bis.read(bytes, 0, bytes.length);
        while (read!=-1){
            os.write(bytes, 0, read);
            os.flush();
            read = bis.read(bytes, 0, bytes.length);
        }

        //...and so on
public void downloadImage() {
     String userAgent = "Mozilla/5.0 (jsoup)";
     int timeout = 5 * 1000;
     String url = "<url>";
     String fileName = "<fileName>";
     Response response = Jsoup.connect(url).userAgent(userAgent).timeout(timeout).followRedirects(true).execute();

     DB db = mongoClient.getDB("<db_name>");
     DBCollection collection = db.getCollection("<db_collection>");

     ByteArrayOutputStream buffer = new ByteArrayOutputStream();

     byte[] buf = new byte[16384];

     InputStream img = getImage(url);

     if(img!=null) {
        for (int readNum; (readNum = img.read(buf)) != -1;) {
        //Writes to this byte array output stream
            buffer.write(buf, 0, readNum);
        }
        byte[] bytes = buffer.toByteArray();

        InputStream in = new ByteArrayInputStream(bytes);

        BufferedInputStream bis = new BufferedInputStream(in);

        GridFS gridfs = new GridFS(db, collection);
        GridFSInputFile gfsFile = gridfs.createFile(bis, fileName);
        fileID = gfsFile.getId();
        System.out.println(fileID);
        gfsFile.setFilename(fileName);
        gfsFile.save();
     }
}

private InputStream getImage(String src) throws IOException {
        int indexname = src.lastIndexOf("/");
        if (indexname == src.length())
            src = src.substring(1, indexname);
        //Open a URL Stream
        URL url = new URL(src);
        InputStream in = url.openStream();
        try {
            in = url.openStream();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            in.close();
        }
        return in;
    }
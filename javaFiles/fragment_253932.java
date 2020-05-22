File file = someMethodToGetFile();
 InputStream jsonInputStream = new FileInputStream(file);
 db.update("document_id",
           jsonInputStream,
           file.length(),
           null);
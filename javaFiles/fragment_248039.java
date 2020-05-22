GridFSDBFile gfsFileOut = (GridFSDBFile) gridfs.findOne(rawName);
    System.out.println(gfsFileOut.getInputStream());
    InputStream is = gfsFileOut.getInputStream();

    // Reading the excel file
    List<String> list = null;
    BufferedReader br = null;
    try {
        String sCurrentLine;
        br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
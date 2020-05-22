File file = new File("/Users/aikaliu/document/micrown/source/img/20160802144001791.jpg");

    final DiskFileItem diskFileItem = new DiskFileItem("fileData", "text/plain", true, file.getName(), 100000000, file.getParentFile());

    InputStream input = null;
    OutputStream os = null;
    try {
        input = new FileInputStream(file);
        os = diskFileItem.getOutputStream();
        IOUtils.copy(input, os);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    MultipartFile multipartFile = new CommonsMultipartFile(diskFileItem);
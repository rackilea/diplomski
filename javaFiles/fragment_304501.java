final String fileName = filePart.getSubmittedFileName();
    File convFile = new File(filePart.getSubmittedFileName());
    FileOutputStream fos = new FileOutputStream(convFile);
    OutputStream out = null;
    InputStream filecontent= null;
    try{
        out = new FileOutputStream(new File(mainPath + File.separator + fileName));
        filecontent = filePart.getInputStream();

        int read = 0;
        final byte[] bytes = new byte[1024];

        while((read = filecontent.read(bytes)) != -1){
            out.write(bytes, 0, read);
        }

        } catch (FileNotFoundException fne) {


        } finally {
           if (out != null) {
               out.close();
           }
           if (filecontent != null) {
               filecontent.close();
           }
       }
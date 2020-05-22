List<FilePart<Object>> fileParts = request().body().asMultipartFormData().getFiles();
        for(FilePart filePart : fileParts) {
           filePart.getFile();
           String myUploadPath = Play.application().configuration().getString("myUploadPath");
           ((File) filePart.getFile()).renameTo(new File(myUploadPath, filePart.getFilename()));
        }
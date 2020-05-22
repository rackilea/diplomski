public static void uploadPictures(long id, String title, File fake) {
    List<Upload> files = (List<Upload>) request.args.get("__UPLOADS");
    if(files != null) {
        Project project = Project.findById(id);
        Picture picture;
        Blob image;
        InputStream inStream;
        for(Upload file: files) {
            if(file != null) {
                try {
                    inStream = new java.io.FileInputStream(file.asFile());
                    image = new Blob();
                    image.set(inStream, new MimetypesFileTypeMap().getContentType(file.asFile()));
                    picture = new Picture(project, file.getFileName(), image);
                    project.addPicture(picture); // stores the picture
                } catch (FileNotFoundException e) {
                    System.out.println(e.toString());
                }
            }
        }
    }
    addPicture(id); //renders the image upload view
}
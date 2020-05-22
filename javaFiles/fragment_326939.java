@POST
@Path("/upload")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response uploadFile(@FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetail) {

    String uploadedFileLocation = "/home/Desktop/" + fileDetail.getFileName();
    // save it
    writeToFile(uploadedInputStream, uploadedFileLocation);
    File file = new File(uploadedFileLocation);
    System.out.println(file.length() + " in bytes");
    String output = "File uploaded to : " + uploadedFileLocation;
    return Response.status(200).entity(output).build();
}

// save uploaded file to new location
private void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) {

    try {
        OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
        int read = 0;
        byte[] bytes = new byte[1024];
        out = new FileOutputStream(new File(uploadedFileLocation));
        while ((read = uploadedInputStream.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        out.flush();
        out.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
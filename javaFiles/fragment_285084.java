@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response upload(@MultipartForm MyEntity entity) throws IOException {

    try (FileOutputStream fos = new FileOutputStream("file.png")) {
        byte[] filebytes = entity.getFile();
        fos.write(filebytes);
    }

    String firstname = entity.getFirstname();
    String lastname = entity.getLastname();
    return Response.ok(firstname + ":" + lastname).build();
}
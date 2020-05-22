@POST
@Path("upload")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public void uploadFile(@FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetail) throws ServiceChannelException {
    OutputStream os = null;
    try {
        File fileToUpload = new File("C:/Users/Public/Pictures/Desert1.jpg");
        os = new FileOutputStream(fileToUpload);
        byte[] b = new byte[2048];
        int length;
        while ((length = uploadedInputStream.read(b)) != -1) {
            os.write(b, 0, length);
        }
    } catch (IOException ex) {
        Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
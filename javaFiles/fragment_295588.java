@Path("/uploadZip")
@POST
@Produces(MediaType.APPLICATION_JSON)
public Response uploadZip(@Context HttpServletRequest req, InputStream payload){

OutputStream fos = new FileOutputStream(new File("path/to/filename.zip");

    try {
        byte[] bufferSize = new byte[1024];
        int i = 0;
        while ((i = payload.read(bufferSize)) != -1) {
            fos.write(buf, 0, i);
        }
    } catch (IOException e) {
        return errorResponse;
    } finally {
        fos.close();
    }
    ...
}
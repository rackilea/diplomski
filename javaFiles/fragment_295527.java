@POST
@Path("/")
@Consumes("multipart/form-data")
public Response uploadFileMultipart(MultipartFormDataInput input) {
        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();

        List<InputPart> inputParts = uploadForm.get("video");

        String videoFileName = "GENERATE_YOUR_FILENAME_HERE.mp4";
        File file = new File(filename);

        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fop = new FileOutputStream(file);
        for (InputPart inputPart : inputParts) {
                InputStream inputStream = inputPart.getBody(InputStream.class, null);
                byte[] content = IOUtils.toByteArray(inputStream);
        fop.write(content);
        }

        fop.flush();
        fop.close();

        return Response.status(HttpStatus.SC_OK).build();
}
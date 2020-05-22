@POST
@Path("files")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response uploadMultipart(FormDataMultiPart multiPart) throws IOException{        
    List<FormDataBodyPart> fields = multiPart.getFields("test");        
    for(FormDataBodyPart field : fields){
        handleInputStream(field.getValueAs(InputStream.class));
    }
    //prepare the response
}

private void handleInputStream(InputStream is){
    //read the stream any way you want
}
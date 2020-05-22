@GET
@Produces("application/pdf")
public Response getResumePdf(@PathParam("userId") String userId) {

    StreamingOutput entity = new StreamingOutput() {
        @Override
        public void write(OutputStream output) {
            try {
                ITextRenderer renderer = new ITextRenderer();
                String yourXhtmlContentAsString = "<h1>hi </h1>";
                renderer.setDocumentFromString(yourXhtmlContentAsString);
                renderer.layout();
                renderer.createPDF(output);
                output.flush();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    return Response.ok(entity)
         .header(...)
         .build();
}
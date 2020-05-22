public Response addWorkflowSchema(
                       @FormDataParam("bpmndata") InputStream in,
                       @FormDataParam("bpmndata") FormDataContentDisposition fdc) {

    String fileName = fdc.getFileName();
}
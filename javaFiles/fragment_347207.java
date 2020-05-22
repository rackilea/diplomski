@PostMapping(value = "/cancel", consumes = { MediaType.TEXT_XML_VALUE,
        MediaType.MULTIPART_FORM_DATA_VALUE }, produces = MediaType.TEXT_XML_VALUE)
public ResponseEntity<CancelResponse> CancelRequest(
        @RequestBody(required = true) CancelRequest cancelRequest) {
    RequestWrapper<CheckRequest, CheckResponse> requestWrapper = 
               requestFactory.requestWrapper(cancelRequest);
     //...
    return new ResponseEntity<CancelResponse>(requestWrapper.getResponse(),
            HttpStatus.OK);
}
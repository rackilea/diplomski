@RequestMapping(value = "/simpleUploader", method = RequestMethod.POST, produces = "application/json")
public ResponseEntity<UploadResponse> simpleUploader(
    ...
    @RequestParam(value = "session", defaultValue = "") String sessionId,
    ... ) throws IOException {
    ....
}
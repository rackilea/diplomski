@GetMapping(path = "download")
public ResponseEntity<Resource> download(String param) throws IOException {

    InputStreamResource resource = new InputStreamResource(/* InputStream of blob */);

    long fileLength = /*Length of content, bytes.length or something */

    return ResponseEntity.ok()
            .contentLength(fileLength)
            .contentType(MediaType.APPLICATION_OCTET_STREAM_VALUE)
            .body(resource);
}
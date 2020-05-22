@RequestMapping(value = "/VMS-49001/playlist/{listName:.+}")
public ResponseEntity<byte[]> testphoto() throws IOException {
    InputStream in = servletContext.getResourceAsStream("/images/no_image.jpg");

    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("application/vnd.apple.mpegurl"));
headers.setContentDispositionFormData(fileName, fileName);

    return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
}
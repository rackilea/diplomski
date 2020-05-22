@RequestMapping (value="/qr/{id}", method = RequestMethod.GET)
public ResponseEntity<byte[]> getQRImage(@PathVariable final String id) {
    byte[] bytes = ...; // Generate the image based on the id

    // Set headers
    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.IMAGE_PNG);

    return new ResponseEntity<byte[]> (bytes, headers, HttpStatus.CREATED);
}
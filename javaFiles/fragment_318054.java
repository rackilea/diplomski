@RequestMapping(method = RequestMethod.GET, value = "/{id}")
public ResponseEntity<byte[]> getPdf(@PathVariable Long id) throws IOException {
    final String filePath = pdfFilePathFinder.find(id);

    final byte[] pdfBytes = Files.readAllBytes(Paths.get(filePath));

    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("application/pdf"));
    headers.setContentDispositionFormData("attachment", null);
    headers.setCacheControl("no-cache");

    return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
}
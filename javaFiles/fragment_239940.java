@RequestMapping(value = GENERATE_BARCODE, method = RequestMethod.GET)
public ResponseEntity get(@PathVariable("input") String barcodeInput) throws IOException {
    byte[] resonse = service.generate(barcodeInput);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.IMAGE_PNG);
    return new ResponseEntity(resonse, headers, HttpStatus.OK);
}
@RequestMapping(value="/getpdf", method=RequestMethod.POST)
public ResponseEntity<byte[]> getPDF(@RequestBody String json) {
    // convert JSON to Employee 
    Employee emp = convertSomehow(json);

    // generate the file
    PdfUtil.showHelp(emp);

    // retrieve contents of "C:/tmp/report.pdf" that were written in showHelp
    byte[] contents = (...);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_PDF);
    // Here you have to set the actual filename of your pdf
    String filename = "output.pdf";
    headers.setContentDispositionFormData(filename, filename);
    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
    ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
    return response;
}
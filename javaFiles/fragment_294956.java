private static final String DIRECTORY = "/Users/username/Documents/";

@RequestMapping(method = RequestMethod.GET, params = "fileName")
@ResponseBody
protected ResponseEntity<byte[]> handleFileRequest(HttpServletRequest request, HttpServletResponse response,
                                                   @RequestParam String fileName) throws Exception {
    // Change below to proper logger, if you have one configured.
    System.out.println("Trying to find file: " + fileName +
                       " from directory: " + DIRECTORY + ".");

    File pdfFile = new File(DIRECTORY + fileName);
    byte[] bytes = FileUtils.readFileToByteArray(pdfFile);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("application/pdf"));
    headers.setContentLength(bytes.length);
    headers.setContentDispositionFormData("filename", fileName);

    return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
}
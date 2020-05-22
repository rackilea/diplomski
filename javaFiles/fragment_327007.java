@GetMapping(value = "/downloadFile", method = RequestMethod.GET,  produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
  public ResponseEntity<?> downloadFile(@RequestParam(value="filename") String filename) {
    String dirPath = "your-location-path";
    byte[] fileBytes = null;
    try {
      fileBytes = Files.readAllBytes(Paths.get(dirPath + fileName));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_OCTET_STREAM)
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
        .body(fileBytes);
  }
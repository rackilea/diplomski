@GetMapping(value = "/showImage", produces = "image/jpg")
  public ResponseEntity<byte[]> getImageAsResponseEntity(
      @RequestParam("fileName") String fileName) {
    String dirPath = "some path in your drive/";
    HttpHeaders headers = new HttpHeaders();
    InputStream in = null;
    byte[] media = new byte[0];
    try {
      in = new FileInputStream(dirPath + fileName);
      media = IOUtils.toByteArray(in);
    } catch (IOException e) {
      e.printStackTrace();
    }
    ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
    return responseEntity;
  }
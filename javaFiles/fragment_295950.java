@RequestMapping(value = "/download", method = RequestMethod.GET)
@ResponseBody
public ResponseEntity<Resource> download() {

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

    InputStream is = null; // get your input stream here
    Resource resource = new InputStreamResource(is);

    return new ResponseEntity<>(resource, headers, HttpStatus.OK);
}
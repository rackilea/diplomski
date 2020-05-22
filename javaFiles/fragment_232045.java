@GetMapping(path = "/pdf", produces = "application/pdf")
ResponseEntity<Resource> getPDF() {
  Resource pdfFile = ...;
  HttpHeaders headers = new HttpHeaders();
  headers.setContentDispositionFormData(file.getName(), file.getName());
  return ResponseEntity
    .ok().cacheControl(CacheControl.noCache())
    .headers(headers).body(resource);
}
@RequestMapping("/handle")
 public ResponseEntity<String> handle() {
   HttpHeaders responseHeaders = new HttpHeaders();
   responseHeaders.set("MyResponseHeader", "MyValue");
   return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
 }
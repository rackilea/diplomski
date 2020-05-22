@GetMapping("/url")
@ResponseBody
public ResponseEntity<?> handlerMethod(/*parameters*/) {
    // ...
    return ResponseEntity.status(/*STATUS CODE*/).body(...);
}
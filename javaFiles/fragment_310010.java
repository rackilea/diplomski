class MyHandlerClass implements Whatever {
    @GetMapping("/thing")
    @User
    public ResponseEntity getThing() {
        ... // user is successfully authenticated, get the "thing" from the database
    }
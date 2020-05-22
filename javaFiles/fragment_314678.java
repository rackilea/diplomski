@PostMapping("/api/signup")
public ResponseEntity signup(HttpServletRequest request, HttpServletResponse response) {
    return ResponseEntity
            .status(<http_status>)
            .contentType(MediaType.APPLICATION_JSON)
            .body("{\"status\":\"fail\", \"message\":\"foo\"}");
}
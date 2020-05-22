@GetMapping("/client/ip")
public ResponseEntity<String> getClientIp(HttpServletRequest request) {
    String clientAddress = "";
    if (Objects.nonNull(request)) {
        clientAddress = request.getHeader("X-FORWARDED-FOR");
        if (Objects.nonNull(request) || "".equals(remoteAddr)) {
            clientAddress = request.getRemoteAddr();
        }
    }
    return ResponseEntity.ok().body(clientAddress);
}
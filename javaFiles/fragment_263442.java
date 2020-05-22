public static ResponseEntity<Void> allows(HttpMethod... methods) {
    HttpHeaders headers = new HttpHeaders();
    Set<HttpMethod> allow = new HashSet<>();
    for(HttpMethod method: methods){
        allow.add(method);
    }
    headers.setAllow(allow);

    return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
}
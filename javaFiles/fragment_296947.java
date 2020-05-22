@RequestMapping(value = "/**")
public ResponseEntity route(HttpServletRequest reqt) throws IOException {
    String body = IOUtils.toString(reqt.getReader());
    try {
        ResponseEntity<Object> response = restTemplate.exchange(someUrl+ request.getRequestURI(),
                HttpMethod.valueOf(request.getMethod()),
                new HttpEntity<>(body),
                Object.class,
                request.getParameterMap());

        final HttpHeaders responseHeaders = new HttpHeaders();
        response.getHeaders().entrySet().stream().forEach(e -> responseHeaders.put(e.getKey(), e.getValue()));
        responseHeaders.remove(HttpHeaders.CONNECTION);
        responseHeaders.remove(HttpHeaders.TRANSFER_ENCODING);

        return new ResponseEntity<>(response.getBody(), responseHeaders, response.getStatusCode());
    } catch (final HttpClientErrorException e) {
        return new ResponseEntity<>(e.getResponseBodyAsByteArray(), e.getResponseHeaders(), e.getStatusCode());
    }
}
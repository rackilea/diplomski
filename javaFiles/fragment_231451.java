@GetMapping("/")
    public ResponseEntity<byte[]> getImage() {
        final ResponseEntity<byte[]> result =  new RestTemplate(messageConverters).exchange(new URI(url), HttpMethod.GET, httpEntity,  byte[].class );
        return ResponseEntity.status(OK)
                .contentType(MediaType.IMAGE_JPEG)
                .body(result.getBody());
    }
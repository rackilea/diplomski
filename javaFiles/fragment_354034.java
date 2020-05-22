public String ocrImage(String path) {

    // getting the file from disk
    FileSystemResource value = new FileSystemResource(new File(path));

    // adding headers to the api
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.MULTIPART_FORM_DATA);
    headers.set("x-key", API_KEY);

    MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
    body.add("file", value);


    HttpEntity<MultiValueMap<String, Object>> requestEntity= new HttpEntity<>(body, headers);

    RestTemplate restTemplate = new RestTemplate();
    String result = restTemplate.postForEntity(EXTERNAL_API_ENDPOINT, requestEntity,
        String.class).getBody().toString();

    System.out.println(result);
    return result;
}
LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
    map.add("file", new FileSystemResource("FILE_LOCATION"));
    HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", "image/png");
    .. other headers...
    HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new    HttpEntity<LinkedMultiValueMap<String, Object>>(
                        map, headers);
    RestTemplate template = new RestTemplate();
    String result = template.postForObject("FILE_UPLOAD_URL",requestEntity, String.class);
    System.out.println(result);
    return result;
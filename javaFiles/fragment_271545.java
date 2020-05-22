HttpEntity request = createLoginRequest(username, password);
String response = template.postForObject(url, request, String.class);

private HttpEntity<MultiValueMap<String, String>> createLoginRequest(String username, String password){
    MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<String, String>();
    requestMap.add("method", "login");
    requestMap.add("input_type", "JSON");
    requestMap.add("response_type", "JSON");
    Map<String, Object> user_auth = new HashMap<String, Object>();
    user_auth.put("user_name", username);
    user_auth.put("password", password);
    Map<String, Object> rest_data = new HashMap<String, Object>();
    rest_data.put("user_auth", user_auth);
    Gson gson = new Gson();
    requestMap.add("rest_data", gson.toJson(rest_data));
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(requestMap, headers);
    return request;
}
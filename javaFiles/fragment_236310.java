MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
headers.add("x-api-key", "randomKey");

HttpEntity<Void> entity = new HttpEntity<>(headers);
entity.getHeaders().setContentType(MediaType.APPLICATION_JSON);

YourResponseType response = restTemplate.exchange(url, HttpMethod.GET, entity, YourResponseType.class);
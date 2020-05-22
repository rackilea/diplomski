String userJsonList = objectMapper.writeValueAsString(userList);

HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_JSON);
HttpEntity<String> entity = new HttpEntity<>(userJsonList, headers);

ResponseEntity<String> response =  restTemplate.postForEntity(URL.toString(), HttpMethod.POST, entity, String.class);
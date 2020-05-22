I added authorization headers in MultiValueMap and i added object request in HttpEntity. here i added code.

MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
headers.add("Authorization", "bearer "+<TOKEN>);
HttpEntity<MyObject> httpEntityRequest = new HttpEntity<>(myObjectReference, headers);

BaseResponseDTO baseResponseDTO = restTemplate.postForObject("http://localhost:80../.../...Report", httpEntityRequest , BaseResponseDTO.class);
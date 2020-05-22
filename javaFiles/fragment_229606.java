public <T> T post(Object content, Class<T> returnType, String url){
        ParameterizedTypeReference<T> typeRef = ParameterizedTypeReference.forType(returnType);
        HttpEntity<Object> requestEntity = new HttpEntity<>(content);
        ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, typeRef);
        return response.getBody();
}
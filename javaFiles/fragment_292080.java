ResponseEntity<String> rest= 
    restTemplate.exchange(
        XBrainTradeQueryURL,
        HttpMethod.POST, 
        new HttpEntity(objectMapper.writeValueAsString(request), headers), 
        String.class);
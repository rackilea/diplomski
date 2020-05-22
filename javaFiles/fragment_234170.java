HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
    HttpEntity<?> entity = new HttpEntity(headers);
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(REVOKE_URL)
            .queryParam("token", tokenDetailsDto.getRefreshToken());
    LOGGER.info("used parameters:\n\turl={},\n\tentity={},\n\turiParameters={}", REVOKE_URL, entity);
    restTemplate.postForObject(builder.build().encode().toUri(), entity, Void.class);
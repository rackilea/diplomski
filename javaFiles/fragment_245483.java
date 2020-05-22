public Object request(final String url, final String parameter) {
    String urlString = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("parameter", "{param}")
            .build()
            .toUriString();
    return restTemplate.getForObject(urlString, Object.class, parameter);
}
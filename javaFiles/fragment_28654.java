HttpHeaders httpHeaders = new HttpHeaders();
httpHeaders.setContentType(MediaType.APPLICATION_JSON);

String url = "http://castor-v2/providers/usable/search";
UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("country-id", countryId)
            .queryParam("network-ids[]", networkId)
            .queryParam("usages[]", Usage.MESSAGE_DELIVERY);

HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

HttpEntity<String> response = restTemplate.exchange(
            builder.toUriString(),
            HttpMethod.GET,
            entity,
            String.class);
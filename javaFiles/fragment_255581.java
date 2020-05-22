UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("example.com");
builder.replaceQueryParam("param1", param1value);
...
restTemplate.exchange(builder.build().encode().toUri(),
                    httpMethod,
                    requestEntity,
                    String.class)
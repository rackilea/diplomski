RestTemplate template;
List<Long> ids;
List<CustomerDto> = template.exchange(
            "/customer/customers/search",
            HttpMethod.POST,
            new HttpEntity<>(ids),
            new ParameterizedTypeReference<List<CustomerDto>>() {}).getBody()
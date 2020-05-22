public class Demo {
    private static RestTemplate restTemplate() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new Jackson2HalModule());

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
        converter.setObjectMapper(mapper);

        return new RestTemplate(Collections.<HttpMessageConverter<?>> singletonList(converter));
    }

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        String URL = "http://localhost:8080/employee-api/employees/160166/employees?page=0&size=25";

        RestTemplate restTemplate = restTemplate();

        ResponseEntity<PagedResources<Resource<EmployeeDto>>> result = restTemplate.exchange(URL, HttpMethod.GET,
                null/* httpEntity */, new ParameterizedTypeReference<PagedResources<Resource<EmployeeDto>>>() {});
        PagedResources<Resource<EmployeeDto>> body = result.getBody();
        ObjectMapper mapper = new ObjectMapper();
        String writeValueAsString = mapper.writeValueAsString(body);

        System.out.println(mapper.writeValueAsString(body));
    }
}
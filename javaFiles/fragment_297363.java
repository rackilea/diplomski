@SpringBootApplication
public class So45333587Application {

    public static void main(String[] args) { SpringApplication.run(So45333587Application.class, args); }

    @Bean
    RestTemplate restTemplate(Validator validator) { return new ValidatableRestTemplate(validator); }

    public static class ValidatableRestTemplate extends RestTemplate {
        private final Validator validator;

        public ValidatableRestTemplate(Validator validator) { this.validator = validator; }

        @Override
        protected <T> T doExecute(URI url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor) throws RestClientException {
            final T response = super.doExecute(url, method, requestCallback, responseExtractor);
            Object  body;
            if (response instanceof ResponseEntity<?>) {
                body = ((ResponseEntity) response).getBody();
            } else {
                body = response;
            }
            final Set<ConstraintViolation<Object>> violations = validator.validate(body);
            if (violations.isEmpty()) {
                return response;
            }

            throw new ConstraintViolationException("Invalid response", violations);
        }
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class Post {
        @Min(2) // change to '1' and constraint violation will disappear
        private Long   id;
        private Long   userId;
        private String title;
        private String body;

        @Override
        public String toString() { 
            return String.format("Post{id=%d, userId=%d, title='%s', body='%s'}", id, userId, title, body); 
        }
    }

    @Bean
    CommandLineRunner startup(RestTemplate restTemplate) {
        return args -> {
            final ResponseEntity<Post> entity = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts/1", HttpMethod.GET, null, Post.class);
            System.out.println(entity.getBody());
        };
    }
}
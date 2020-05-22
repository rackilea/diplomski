public class ValidatableRestTemplate extends RestTemplate {

    private final Validator validator;

    public ValidatableRestTemplate(Validator validator) {
        this.validator = validator;
    }

    @Override
    protected <T> T doExecute(URI url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor) throws RestClientException {
        final T response = super.doExecute(url, method, requestCallback, responseExtractor);
        Object  body;
        if (response instanceof ResponseEntity<?>) {
            body = ((ResponseEntity) response) .getBody();
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
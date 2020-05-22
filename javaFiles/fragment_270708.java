@SuppressWarnings("unchecked")
private  <T extends Data> List<T> validateAndGetResponses(List<Response<? extends Data>> responses, Class<T> clazz) {
    return responses.stream().map(this::getData)
                             .filter(clazz::isInstance)
                             .map(r -> (T) r)
                             .collect(Collectors.toList());
}
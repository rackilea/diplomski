public abstract class GenericClient<DTO> {
  private final Class<DTO> dtoClass;
  ... ctor which sets dtoClass ...


  public List<DTO> findAll() {
    ...
    URI uri = ...
    ResponseEntity<List<DTO>> exchange = getRestTemplate()
      .exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<List<DTO>() {
        @Override
        public Type getType() {
            return new ParameterizedType() {
                @Override
                public Type getRawType() {
                    return List.class;
                }

                @Override
                public Type getOwnerType() {
                    return null;
                }

                @Override
                public Type[] getActualTypeArguments() {
                    return new Type[]{dtoClass};
                }
            };
        });
    return exchange.getBody(); // OK
  }
}
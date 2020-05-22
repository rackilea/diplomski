protected final List<Long> extractIdFromResult(Map<String, Object> pResult, String pKey) {
    System.out.println("is pKey available in map "+pResult.get(pKey));
    // There is a chance that the pKey can be something which is not available in the map.
    return new SqlArrayExtractor<Long>(pResult.get(pKey)).extract(new Transformer() {
      @Override
      public Long transform(Object pInput) {
        return Long.valueOf(((BigDecimal) pInput).longValue());
      }
    });
}
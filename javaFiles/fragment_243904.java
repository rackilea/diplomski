private List<Result> getResultList(List<String> names) throws ResultClassException {
  try {
    return names.stream()
        .map(this::getOrCreateResult)
        .collect(collectingAndThen(toList(), Collections::unmodifiableList));
  } catch (RuntimeException e) {
    if (e.getCause() instanceof CustomException) {
      throw new ResultClassException("Error", e.getCause());
    }
    throw e;
    // Or use Guava's propagate
  }
}

private Result getOrCreateResult(String name) {
  if (!resultRepository.contains(name)) {
    try {
      return createResult(name);
    } catch (CustomException e) {
      throw new RuntimeException(e);
    }
  } else {
    log.info("Result {} already exists.", name);
    return resultRepository.get(name);
  }
}
for (Entry<Supplier<Boolean>, String> e : conditions.entrySet()) {
  if (e.getKey().get()) {
    validatorVO.setErrorCode(e.getValue());
    break;
  }
}
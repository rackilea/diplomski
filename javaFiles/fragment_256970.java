/**
   * Implemented to fail with a useful error message.
   */
  public final String getClassNameForTypeId(String id)
      throws SerializationException {
    throw new SerializationException(ELISION_ERROR);
  }
/**
   * @param id The value of the "id" attribute to search for
   * @return a By which locates elements by the value of the "id" attribute.
   */
  public static By id(final String id) {
    if (id == null)
      throw new IllegalArgumentException(
          "Cannot find elements with a null id attribute.");

    return new ById(id);
  }
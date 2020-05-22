/**
   * @param linkText The exact text to match against
   * @return a By which locates A elements by the exact text it displays
   */
  public static By linkText(final String linkText) {
    if (linkText == null)
      throw new IllegalArgumentException(
          "Cannot find elements when link text is null.");

    return new ByLinkText(linkText);
  }
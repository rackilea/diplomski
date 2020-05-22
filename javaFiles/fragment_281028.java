/**
   * @param linkText The text to match against
   * @return a By which locates A elements that contain the given link text
   */
  public static By partialLinkText(final String linkText) {
    if (linkText == null)
      throw new IllegalArgumentException(
          "Cannot find elements when link text is null.");

    return new ByPartialLinkText(linkText);
  }
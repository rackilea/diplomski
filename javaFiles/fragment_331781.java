public List<ContentObject> parseContentObjects(
    )
  {
    final List<ContentObject> contentObjects = new ArrayList<ContentObject>();
    while(moveNext())
    {
      ContentObject contentObject = parseContentObject();
      // Multiple-operation graphics object end?
      if(contentObject instanceof EndText // Text.
        || contentObject instanceof RestoreGraphicsState // Local graphics state.
       /* || contentObject instanceof EndMarkedContent // End marked-content sequence. */
        || contentObject instanceof EndInlineImage) // Inline image.
        return contentObjects;

      contentObjects.add(contentObject);
    }
    return contentObjects;
  }
public ContentObject parseContentObject(
    )
  {
    final Operation operation = parseOperation();
    if(operation instanceof PaintXObject) // External object.
      return new XObject((PaintXObject)operation);
    else if(operation instanceof PaintShading) // Shading.
      return new Shading((PaintShading)operation);
    else if(operation instanceof BeginSubpath
      || operation instanceof DrawRectangle) // Path.
      return parsePath(operation);
    else if(operation instanceof BeginText) // Text.
      return new Text(
        parseContentObjects()
        );
    else if(operation instanceof SaveGraphicsState) // Local graphics state.
      return new LocalGraphicsState(
        parseContentObjects()
        );
 /*   else if(operation instanceof BeginMarkedContent) // Marked-content sequence.
      return new MarkedContent(
        (BeginMarkedContent)operation,
        parseContentObjects()
        );
 */   else if(operation instanceof BeginInlineImage) // Inline image.
      return parseInlineImage();
    else // Single operation.
      return operation;
  }
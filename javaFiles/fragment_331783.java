/**
    Gets the unscaled height of the given character.

    @param textChar
      Character whose height has to be calculated.
  */
  public final double getHeight(
    char textChar
    )
  {
    /*
      TODO: Calculate actual text height through glyph bounding box.
    */
    if(textHeight == -1)
    {textHeight = getAscent() - getDescent();}
    return textHeight;
  }
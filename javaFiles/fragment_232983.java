g.setRenderingHint(
    RenderingHints.KEY_TEXT_ANTIALIASING, 
    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

Map<TextAttribute, Object> atts = new HashMap<TextAttribute, Object>();
atts.put(TextAttribute.KERNING, TextAttribute.KERNING_ON);
font = font.deriveFont(atts);
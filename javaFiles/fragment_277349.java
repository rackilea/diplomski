Font font = label.getFont();

font = font.deriveFont(
    Collections.singletonMap(
        TextAttribute.WEIGHT, TextAttribute.WEIGHT_SEMIBOLD));

label.setFont(font);
Map<TextAttribute, Object> attributes = new HashMap<>();

attributes.put(TextAttribute.FAMILY, Font.DIALOG);
attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_SEMIBOLD);
attributes.put(TextAttribute.SIZE, 12);

label.setFont(Font.getFont(attributes));
AttributedString a = new AttributedString(text);

// We want first two characters drawn in red.
a.addAttribute(TextAttribute.FOREGROUND, Color.RED, 0, 2);

graphics.drawString(a.getIterator(), x, y);
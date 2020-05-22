String s = "ax [m/s2]";
AttributedString as = new AttributedString(s);
as.addAttribute(TextAttribute.SIZE, 24, 0, 2);
as.addAttribute(TextAttribute.SIZE, 16, 3, 9);
as.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD, 0, 2);
as.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUB, 1, 2);
as.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 7, 8);
domain.setAttributedLabel(as);
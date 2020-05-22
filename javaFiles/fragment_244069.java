Color colour = rule.getPatternFormatting().getFillBackgroundColorColor();
if (colour instanceof ExtendedColor) {
   System.out.println("Colour is " + ((ExtendedColor)colour).getARGBHex());
} else {
   System.out.println("Colour is " + ((HSSFColor)colour).getHexString());
}
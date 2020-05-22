Matcher komen=Pattern.compile("//.+").matcher(source.getText());
while(komen.find())
{
    StyleContext sc = StyleContext.getDefaultStyleContext();
    AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.RED);
    aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Concolas");

    source.select(komen.start(), komen.end());

    source.setCharacterAttributes(aset, false);
}
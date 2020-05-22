int defaultFontSizePreset = 2;
    for(int i=0; i < stylePresetButtons.length; i++) {
    textSizePreset[i] = defaultFontSizePreset;
    String convertedFontSizeText;
    convertedFontSizeText = Integer.toString(textSizePreset[i]);
    stylePresetButtons[i].setText(convertedFontSizeText);
    defaultFontSizePreset += 2;
    System.out.println(defaultFontSizePreset);
}
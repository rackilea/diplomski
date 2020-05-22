List<TextWithFont> fontify(List<PDFont> fonts, String text) throws IOException {
    List<TextWithFont> result = new ArrayList<>();
    if (text.length() > 0) {
        PDFont currentFont = null;
        int start = 0;
        for (int i = 0; i < text.length(); ) {
            int codePoint = text.codePointAt(i);
            int codeChars = Character.charCount(codePoint);
            String codePointString = text.substring(i, i + codeChars);
            boolean canEncode = false;
            for (PDFont font : fonts) {
                try {
                    font.encode(codePointString);
                    canEncode = true;
                    if (font != currentFont) {
                        if (currentFont != null) {
                            result.add(new TextWithFont(text.substring(start, i), currentFont));
                        }
                        currentFont = font;
                        start = i;
                    }
                    break;
                } catch (Exception ioe) {
                    // font cannot encode codepoint
                }
            }
            if (!canEncode) {
                throw new IOException("Cannot encode '" + codePointString + "'.");
            }
            i += codeChars;
        }
        result.add(new TextWithFont(text.substring(start, text.length()), currentFont));
    }
    return result;
}
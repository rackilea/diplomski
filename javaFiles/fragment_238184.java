static public String formatParagraph(String text, int maxWidth)
{
    String[] words = text.split("\\s+");

    StringBuilder pp = new StringBuilder();
    StringBuilder line = new StringBuilder();
    for (String w : words) {
        if (line.length() + w.length() + 1 > maxWidth) {
            if (pp.length() > 0) {
                pp.append(System.lineSeparator());
            }
            pp.append(line.toString());
            line.setLength(0);
        }
        if (line.length() > 0) {
            line.append(' ');
        }
        line.append(w);
    }
    if (line.length() > 0) {
        if (pp.length() > 0)
            pp.append(System.lineSeparator());
        pp.append(line);
    }
    return pp.toString();
}
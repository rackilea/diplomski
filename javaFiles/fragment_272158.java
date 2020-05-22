private String clipText(FontMetrics metrics, String text) {
    String clipped = "...";

    if (metrics.stringWidth(clipped) < MAX_TEXT_WIDTH) {
        StringBuilder sb = new StringBuilder(clipped);

        int index = 0;
        for (char c : text.toCharArray()) {
            sb.insert(index, c);
            if (metrics.stringWidth(sb.toString()) > MAX_TEXT_WIDTH) {
                clipped = sb.deleteCharAt(index).toString();
                break;
            }
            index++;
        }
    }
    return clipped;
}
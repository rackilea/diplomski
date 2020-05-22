Font font = new Font("Serif", Font.PLAIN, 12);
FontMetrics fontMetrics = getFontMetrics(font);

String text = "a line\nanother line\nsome more line";
String[] lines = text.split("\n");
int lineCount = lines.length;

for(String line : lines) {
    int width = fontMetrics.stringWidth(line); 
    lineCount += (width / 500) > 1 ? (width / 500) - 1 : 0;
}
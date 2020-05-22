public int countLines(int width) {

        FontMetrics fontMetrics = this.getFontMetrics(this.getFont());
        String text = this.getText();
        String[] tokens = text.split(" ");
        String currentLine = "";
        boolean beginningOfLine = true;
        int noLines = 1;

        for (int i = 0; i < tokens.length; i++) {
            if (beginningOfLine) {
                beginningOfLine = false;
                currentLine = currentLine + tokens[i];
            } else {
                currentLine = currentLine + " " + tokens[i];
            }

            if (fontMetrics.stringWidth(currentLine) > width) {
                currentLine = "";
                beginningOfLine = true;
                noLines++;
            }
        }

        System.out.print("there are " + noLines + "lines" + System.getProperty("line.separator"));
        return noLines;
}
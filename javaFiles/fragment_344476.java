PDDocument document = PDDocument.load(SOURCE);

PDFDomTree parser = new PDFDomTree(PDFDomTreeConfig.createDefaultConfig()) {
    @Override
    protected void processTextPosition(TextPosition text) {
        if (text.getUnicode().trim().isEmpty()) {
            //finish current box (if any)
            if (lastText != null)
            {
                finishBox();
            }
            //start a new box
            curstyle = new BoxStyle(style);
            lastText = null;
        } else {
            super.processTextPosition(text);
        }
    }
};
Writer output = new PrintWriter(TARGET, "utf-8");

parser.writeText(document, output);
output.close();
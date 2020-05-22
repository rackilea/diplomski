PDFTextStripper stripper = new PDFTextStripper()
{
    @Override
    protected void startPage(PDPage page) throws IOException
    {
        startOfLine = true;
        super.startPage(page);
    }

    @Override
    protected void writeLineSeparator() throws IOException
    {
        startOfLine = true;
        super.writeLineSeparator();
    }

    @Override
    protected void writeString(String text, List<TextPosition> textPositions) throws IOException
    {
        if (startOfLine)
        {
            TextPosition firstProsition = textPositions.get(0);
            writeString(String.format("[%s]", firstProsition.getXDirAdj()));
            startOfLine = false;
        }
        super.writeString(text, textPositions);
    }
    boolean startOfLine = true;
};

text = stripper.getText(document);
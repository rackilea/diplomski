public class SimplePdfCreator
{
    /**
     * Creates a {@link SimplePdfCreator} instance writing to the
     * given {@link OutputStream}.
     */
    public SimplePdfCreator(OutputStream os) throws IOException
    {
        pdfOs = os instanceof BufferedOutputStream ? (BufferedOutputStream) os : new BufferedOutputStream(os);

        writeHeader();
        fontObjectNr = writeFont();
        initPage();
    }

    /**
     * Sets the (fill) color for the upcoming operations on the current page.
     */
    public void color(float r, float g, float b)
    {
        pageBuilder.append(r)
                   .append(' ')
                   .append(g)
                   .append(' ')
                   .append(b)
                   .append(" rg\n");
    }

    /**
     * Sets the background (fill) color for the upcoming operations on the current page.
     */
    public void backColor(float r, float g, float b)
    {
        backBuilder.append(r)
                   .append(' ')
                   .append(g)
                   .append(' ')
                   .append(b)
                   .append(" rg\n");
    }

    /**
     * Prints the given text on a baseline starting at the given coordinates
     * on the current page.
     */
    public void print(int x, int y, String string)
    {
        pageBuilder.append(x - xNow)
                   .append(' ')
                   .append(y - yNow)
                   .append(" Td (")
                   .append(string)
                   .append(") Tj\n");
        xNow = x;
        yNow = y;
        fillBack(string);
    }

    /**
     * Prints the given text on the next line on the current page.
     */
    public void print(String string)
    {
        pageBuilder.append("(")
                   .append(string)
                   .append(") '\n");
        yNow -= leading;
        fillBack(string);
    }

    /**
     * Stores the current page with the printed content in the output
     * and creates a new one.
     */
    public void storePage() throws IOException
    {
        writePageContent();
        initPage();
    }

    /**
     * Returns the width of the given String.
     */
    public double getStringWidth(String string)
    {
        return string.length() * fontSize * .6;
    }

    /**
     * Returns the font size
     */
    public int getFontSize()
    {
        return fontSize;
    }

    /**
     * Returns the leading
     */
    public int getLeading()
    {
        return leading;
    }

    /**
     * Finishes the output writing required data to it and closing the
     * target {@link OutputStream}.
     */
    public void close() throws IOException
    {
        int pagesObjectNr = writePages();
        int catalogObjectNr = writeCatalog(pagesObjectNr);
        long xrefPosition = writeXref();
        writeTrailer(catalogObjectNr);
        writeFooter(xrefPosition);
        pdfOs.close();;
    }

    //
    // helper methods
    //
    void writeHeader() throws IOException
    {
        write("%PDF-1.4\n".getBytes(charSet));
        write(new byte[]{'%', (byte)128, (byte)129, (byte)130, '\n'});
    }

    int writeFont() throws IOException
    {
        return writeObject("<</Type/Font/Subtype/Type1/BaseFont/Courier/Encoding/WinAnsiEncoding>>\n".getBytes(charSet));
    }

    void initPage()
    {
        pageBuilder.setLength(0);
        backBuilder.setLength(0);
        pageBuilder.append("BT/F0 ")
                   .append(fontSize)
                   .append(" Tf ")
                   .append(leading)
                   .append(" TL 0 g\n");
        backBuilder.append("1 g\n");
        xNow = 0;
        yNow = 0;
    }

    void fillBack(String string)
    {
        backBuilder.append(xNow)
                   .append(' ')
                   .append(yNow - leading*.2)
                   .append(' ')
                   .append(getStringWidth(string))
                   .append(' ')
                   .append(leading)
                   .append(" re f\n");
    }

    void writePageContent() throws IOException
    {
        pageBuilder.append("ET\n");
        StringBuilder contents = new StringBuilder();
        contents.append("<</Length ")
                .append(pageBuilder.length() + backBuilder.length())
                .append(">>\nstream\n")
                .append(backBuilder)
                .append(pageBuilder)
                .append("\nendstream\n");
        int contentsObjectNr = writeObject(contents.toString().getBytes(charSet));
        pageContentsObjects.add(contentsObjectNr);
    }

    int writePages() throws IOException
    {
        int pagesObjectNrToBe = xref.size() + pageContentsObjects.size() + 1;
        StringBuilder pages = new StringBuilder();
        pages.append("<</Type /Pages /Count ")
             .append(pageContentsObjects.size())
             .append("/Kids[");
        for (int pageContentObject : pageContentsObjects)
        {
            int pageObjectNr = writeObject(String.format("<</Type/Page/Parent %s 0 R/Contents %s 0 R>>\n", pagesObjectNrToBe, pageContentObject).getBytes(charSet));
            pages.append(pageObjectNr).append(" 0 R ");
        }
        pages.append("]/Resources<</ProcSet[/PDF/Text]/Font<</F0 ")
             .append(fontObjectNr)
             .append(" 0 R>>>>/MediaBox[0 0 612 792]>>\n");
        return writeObject(pages.toString().getBytes(charSet));
    }

    int writeCatalog(int pagesObjectNr) throws IOException
    {
        return writeObject(String.format("<</Type/Catalog/Pages %s 0 R>>\n", pagesObjectNr).getBytes(charSet));
    }

    long writeXref() throws IOException
    {
        long xrefPos = position;
        byte[] eol = new byte[]{'\n'};
        write("xref\n".getBytes(charSet));
        write(String.format("0 %s\n", xref.size() + 1).getBytes(charSet));
        write("0000000000 65535 f ".getBytes(charSet));
        write(eol);
        for(long position: xref)
        {
            write(String.format("%010d 00000 n ", position).getBytes(charSet));
            write(eol);
        }
        return xrefPos;
    }

    void writeTrailer(int catalogObjectNr) throws IOException
    {
        write(String.format("trailer\n<</Size %s/Root %s 0 R>>\n", xref.size() + 1, catalogObjectNr).getBytes(charSet));
    }

    void writeFooter(long xrefPosition) throws IOException
    {
        write(String.format("startxref\n%s\n%%%%EOF\n", xrefPosition).getBytes(charSet));
    }

    int writeObject(byte[] bytes) throws IOException
    {
        int objectNr = startObject();
        write(bytes);
        endObj();
        return objectNr;
    }

    int startObject() throws IOException
    {
        xref.add(position);
        int objectNr = xref.size();
        write(String.format("%s 0 obj\n", objectNr).getBytes(charSet));
        return objectNr;
    }

    void endObj() throws IOException
    {
        write("endobj\n".getBytes(charSet));
    }

    long write(byte[] bytes) throws IOException
    {
        if (bytes != null)
        {
            pdfOs.write(bytes);
            position += bytes.length;
        }
        return position;
    }

    final BufferedOutputStream pdfOs;
    final Charset charSet = Charset.forName("ISO-8859-1");
    final List<Long> xref = new ArrayList<Long>();
    final List<Integer> pageContentsObjects = new ArrayList<Integer>();
    final StringBuilder pageBuilder = new StringBuilder();
    final StringBuilder backBuilder = new StringBuilder();
    final int fontObjectNr;
    long position = 0;

    int xNow = 0;
    int yNow = 0;

    int fontSize = 11;
    int leading = 11;
}
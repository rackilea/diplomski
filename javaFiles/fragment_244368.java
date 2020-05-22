public final class RemoveFontF2
{
    /**
     * Default constructor.
     */
    private RemoveFontF2()
    {
        // example class should not be instantiated
    }

    /**
     * This will remove all text from a PDF document.
     *
     * @param args The command line arguments.
     *
     * @throws IOException If there is an error parsing the document.
     */
    public static void main(String[] args) throws IOException
    {
        if (args.length != 2)
        {
            usage();
        }
        else
        {
            PDDocument document = PDDocument.load(new File(args[0]));
            if (document.isEncrypted())
            {
                System.err.println(
                        "Error: Encrypted documents are not supported for this example.");
                System.exit(1);
            }
            for (PDPage page : document.getPages())
            {
                List<Object> newTokens = createTokensWithoutText(page);
                PDStream newContents = new PDStream(document);
                writeTokensToStream(newContents, newTokens);
                page.setContents(newContents);
                processResources(page.getResources());
            }
            document.save(args[1]);
            document.close();
        }
    }

    private static void processResources(PDResources resources) throws IOException
    {
        for (COSName name : resources.getXObjectNames())
        {
            PDXObject xobject = resources.getXObject(name);
            if (xobject instanceof PDFormXObject)
            {
                PDFormXObject formXObject = (PDFormXObject) xobject;
                writeTokensToStream(formXObject.getContentStream(),
                        createTokensWithoutText(formXObject));
                processResources(formXObject.getResources());
            }
        }
        for (COSName name : resources.getPatternNames())
        {
            PDAbstractPattern pattern = resources.getPattern(name);
            if (pattern instanceof PDTilingPattern)
            {
                PDTilingPattern tilingPattern = (PDTilingPattern) pattern;
                writeTokensToStream(tilingPattern.getContentStream(),
                        createTokensWithoutText(tilingPattern));
                processResources(tilingPattern.getResources());
            }
        }
    }

    private static void writeTokensToStream(PDStream newContents, List<Object> newTokens) throws IOException
    {
        OutputStream out = newContents.createOutputStream(COSName.FLATE_DECODE);
        ContentStreamWriter writer = new ContentStreamWriter(out);
        writer.writeTokens(newTokens);
        out.close();
    }

    private static List<Object> createTokensWithoutText(PDContentStream contentStream) throws IOException
    {
        PDFStreamParser parser = new PDFStreamParser(contentStream);
        Object token = parser.parseNextToken();
        List<Object> newTokens = new ArrayList<Object>();
        while (token != null)
        {
            if (token instanceof Operator)
            {
                Operator op = (Operator) token;
                String opName = op.getName();
                if (OperatorName.SET_FONT_AND_SIZE.equals(opName) &&
                    newTokens.get(newTokens.size() - 2).equals(COSName.getPDFName("F2")))
                {
                    // remove the 2 arguments to this operator
                    newTokens.remove(newTokens.size() - 1);
                    newTokens.remove(newTokens.size() - 1);

                    token = parser.parseNextToken();
                    continue;
                }
            }
            newTokens.add(token);
            token = parser.parseNextToken();
        }
        // remove F2
        COSBase fontBase = contentStream.getResources().getCOSObject().getItem(COSName.FONT);
        if (fontBase instanceof COSDictionary)
        {
            ((COSDictionary) fontBase).removeItem(COSName.getPDFName("F2"));
        }
        return newTokens;
    }

    /**
     * This will print the usage for this document.
     */
    private static void usage()
    {
        System.err.println("Usage: java " + RemoveFontF2.class.getName() + " <input-pdf> <output-pdf>");
    }

}
public static void main(String[] args) throws IOException, COSVisitorException
{
    File input = new File("G:\\Sales.pdf");

    PDDocument outputDocument = null;
    PDDocument inputDocument = PDDocument.loadNonSeq(input, null);
    PDFTextStripper stripper = new PDFTextStripper();
    String currentNo = null;
    for (int page = 1; page <= inputDocument.getNumberOfPages(); ++page)
    {
        stripper.setStartPage(page);
        stripper.setEndPage(page);
        String text = stripper.getText(inputDocument);
        Pattern p = Pattern.compile("Invoice No.(\\s\\w\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d)");

        // Matcher refers to the actual text where the pattern will be found
        Matcher m = p.matcher(text);
        String no = null;
        if (m.find())
        {
            no = m.group(1);
        }
        System.out.println("page: " + page + ", value: " + no);

        PDPage pdPage = (PDPage) inputDocument.getDocumentCatalog().getAllPages().get(page - 1);

        if (no != null && !no.equals(currentNo))
        {
            saveCloseCurrent(currentNo, outputDocument);
            // create new document
            outputDocument = new PDDocument();
            currentNo = no;
        }
        if (no == null && currentNo == null)
        {
            System.out.println ("header page ??? " + page + " skipped");
            continue;
        }
        // append page to current document
        outputDocument.importPage(pdPage);
    }
    saveCloseCurrent(currentNo, outputDocument);
    inputDocument.close();
}

private static void saveCloseCurrent(String currentNo, PDDocument outputDocument)
        throws IOException, COSVisitorException
{
    // save to new output file
    if (currentNo != null)
    {
        // save document into file
        File f = new File(currentNo + ".pdf");
        if (f.exists())
        {
            System.err.println("File " + f + " exists?!");
            System.exit(-1);
        }
        outputDocument.save(f);
        outputDocument.close();
    }
}
try (   PDDocument document = PDDocument.load(...)    )
{
    PrintImageLocations printer = new PrintImageLocationsImproved();
    int pageNum = 0;
    for( PDPage page : document.getPages() )
    {
        pageNum++;
        System.out.println( "Processing page: " + pageNum );
        printer.processPage(page);
    }
}
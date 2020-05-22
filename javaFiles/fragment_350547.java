public void testtestDrJorge() throws IOException
{
    try (InputStream resource = getClass().getResourceAsStream("testDrJorge.pdf"))
    {
        PDDocument document = PDDocument.load(resource);
        extractPatternImages(document, "testDrJorge%s.%s");;
    }
}
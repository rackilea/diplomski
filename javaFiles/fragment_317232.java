PdfReader pdfReader = new PdfReader(SOURCE);
PdfStamper pdfStamper = new PdfStamper(pdfReader, RESULT_STREAM);
SimpleTextRemover remover = new SimpleTextRemover();

System.out.printf("\ntest.pdf - Test\n");
for (int i = 1; i <= pdfReader.getNumberOfPages(); i++)
{
    System.out.printf("Page %d:\n", i);
    List<List<Glyph>> matches = remover.remove(pdfStamper, i, "Test");
    for (List<Glyph> match : matches) {
        Glyph first = match.get(0);
        Vector baseStart = first.base.getStartPoint();
        Glyph last = match.get(match.size()-1);
        Vector baseEnd = last.base.getEndPoint();
        System.out.printf("  Match from (%3.1f %3.1f) to (%3.1f %3.1f)\n", baseStart.get(I1), baseStart.get(I2), baseEnd.get(I1), baseEnd.get(I2));
    }
}

pdfStamper.close();
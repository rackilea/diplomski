try (   InputStream resource = getClass().getResourceAsStream("test.pdf");
        OutputStream result = new FileOutputStream(new File(RESULT_FOLDER, "testSignedWithSeparatedHashing.pdf"));
        PDDocument pdDocument = PDDocument.load(resource)   )
{
    sign(pdDocument, result, data -> signWithSeparatedHashing(data));
}
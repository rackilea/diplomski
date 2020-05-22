public void testAddPicture() throws IOException
{
    org.pdfclown.files.File file = new org.pdfclown.files.File();

    Page page = new Page(file.getDocument());
    file.getDocument().getPages().add(page);
    PrimitiveComposer primitiveComposer = new PrimitiveComposer(page);

    Image image = Image.get("src\\test\\resources\\mkl\\testarea\\pdfclown0\\content\\Willi-1.jpg");
    XObject imageXObject = image.toXObject(file.getDocument());
    primitiveComposer.showXObject(imageXObject, new Point2D.Double(100,100), new Dimension(300, 300));                 

    primitiveComposer.flush();

    file.save(new File(RESULT_FOLDER, "PdfWithImage.pdf"), SerializationModeEnum.Standard);
    file.close();
}
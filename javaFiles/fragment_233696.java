XWPFDocument doc = new XWPFDocument(OPCPackage.open(fileLocationPath + "Document.doc"));


    List<XWPFParagraph>  paragraphs = doc.getParagraphs();


    XWPFParagraph paragraph =  paragraphs.get(paragraphs.size() - 1);

    XWPFRun runText = paragraph.createRun();

//if you want to add text
    runText.setText("appending here");

//if you want to add image
    runText.addPicture(java.io.InputStream pictureData, int pictureType, java.lang.String filename, int width, int height)



    try (FileOutputStream out = new FileOutputStream(fileLocationPath + "Document.doc")) {
            doc.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
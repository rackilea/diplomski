byte[] byteData = ....

// read as XWPFDocument from byte[]
XWPFDocument doc = new XWPFDocument(new ByteArrayInputStream(byteData));

int numberToPrint = 0;

// you can edit paragraphs
for (XWPFParagraph para : doc.getParagraphs()) {
    List<XWPFRun> runs = para.getRuns();

    numberToPrint++;

    for (XWPFRun run : runs) {

        // read text
        String text = run.getText(0);

        // edit text and update it
        run.setText(numberToPrint + " " + text, 0);
    }
}

// save it and you can get the updated .docx
FileOutputStream fos = new FileOutputStream(new File("updated.docx"));
doc.write(fos);
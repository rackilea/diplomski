// table is a XWPFTable object instantiated earlier in the code
XWPFParagraph paragraph = table.getRow(0).getCell(0).addParagraph();
XWPFRun run = paragraph.createRun();
FileInputStream fis = new FileInputStream("C:\\ [filepath for the image]");
XWPFPicture picture = run.addPicture(fis, XWPFDocument.PICTURE_TYPE_PNG, "Name", Units.pixelToEMU(300), Units.pixelToEMU(150));
System.out.println(picture.getCTPicture());
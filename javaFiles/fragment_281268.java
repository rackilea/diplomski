XWPFDocument document = new XWPFDocument(new FileInputStream("template.docx"));

  System.out.println(document.getStyles().styleExist("CUSTOMYNP"));
  System.out.println(document.getStyles().getStyle("CUSTOMYNP").getName());

  XWPFParagraph paragraph=document.createParagraph();
  paragraph.setStyle("CUSTOMYNP");
  XWPFRun run=paragraph.createRun();
  run.setText("TEST");

  document.write(new FileOutputStream("myDoc.docx"));
  document.close();
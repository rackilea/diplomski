XWPFDocument doc = new XWPFDocument(OPCPackage.open("input.docx"));
for (XWPFParagraph p : doc.getParagraphs()) {
    List<XWPFRun> runs = p.getRuns();
    if (runs != null) {
        for (XWPFRun r : runs) {
            String text = r.getText(0);
            if (text != null && text.contains("needle")) {
                text = text.replace("needle", "haystack");
                r.setText(text, 0);
            }
        }
    }
}
for (XWPFTable tbl : doc.getTables()) {
   for (XWPFTableRow row : tbl.getRows()) {
      for (XWPFTableCell cell : row.getTableCells()) {
         for (XWPFParagraph p : cell.getParagraphs()) {
            for (XWPFRun r : p.getRuns()) {
              String text = r.getText(0);
              if (text != null && text.contains("needle")) {
                text = text.replace("needle", "haystack");
                r.setText(text,0);
              }
            }
         }
      }
   }
}
doc.write(new FileOutputStream("output.docx"));
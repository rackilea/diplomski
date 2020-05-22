XWPFDocument doc = new XWPFDocument(new FileInputStream(fileName));
            List<XWPFTable> table = doc.getTables();
            for (XWPFTable xwpfTable : table) {
                List<XWPFTableRow> row = xwpfTable.getRows();
                for (XWPFTableRow xwpfTableRow : row) {
                    List<XWPFTableCell> cell = xwpfTableRow.getTableCells();
                    for (XWPFTableCell xwpfTableCell : cell) {
                        if (xwpfTableCell != null) {
                            System.out.println(xwpfTableCell.getText());
                            String s = xwpfTableCell.getText();
                            for (XWPFParagraph p : xwpfTableCell.getParagraphs()) {
                                for (XWPFRun run : p.getRuns()) {
                                    for (XWPFPicture pic : run.getEmbeddedPictures()) {
                                        byte[] pictureData = pic.getPictureData().getData();
                                        System.out.println("picture : " + pictureData);
                                    }
                                }
                            }
                        }
                    }
                }
            }
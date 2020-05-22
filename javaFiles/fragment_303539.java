private static final String FILE_NAME = "/tmp/Diskade.docx";

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(FILE_NAME);
        XWPFDocument doc = new XWPFDocument(fis);

        Iterator<IBodyElement> iter = doc.getBodyElementsIterator();
        while (iter.hasNext()) {
            IBodyElement elem = iter.next();
            if (elem instanceof XWPFTable) {

                List<XWPFTableRow> rows = ((XWPFTable) elem).getRows();
                for(XWPFTableRow row :rows){
                    List<XWPFTableCell> cells = row.getTableCells();

                    for(XWPFTableCell cell : cells){

                        String celltext = cell.getText();
                        XWPFParagraph paragraph = cell.addParagraph();
                        setRun(paragraph.createRun() , "Arial" , 10, "2b5079" , celltext , false, false);
                        System.out.print(cell.getParagraphs().get(0).getParagraphText() + " - ");

                    }
                    System.out.println();
                }
            }
        }
    }

    private static void setRun (XWPFRun run , String fontFamily , int fontSize , String colorRGB , String text , boolean bold , boolean addBreak) {
        run.setFontFamily(fontFamily);
        run.setFontSize(fontSize);
        run.setColor(colorRGB);
        run.setText(text);
        run.setBold(bold);
        if (addBreak) run.addBreak();
    }
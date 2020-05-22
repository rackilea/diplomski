public class Bill {

    public static void writeDate(XWPFDocument document) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy         hh:mm:ss");
        String date = sdf.format(new Date()); 

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(date);
    }

    public static void main(String[] args) throws Exception {

        XWPFDocument document = new XWPFDocument();
        writeDate(document);
        FileOutputStream out = new FileOutputStream("createparagraph.docx");
        document.write(out);
        out.close();
    }
}
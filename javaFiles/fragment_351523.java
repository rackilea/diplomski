Student student = new Student ();
String [] details = {"Detail1: ", "Detail2: ", "Detail3: ", "Detail4: ", "Detail5: "};
FileInputStream fis;
String imageName;
int index;
File file;

XWPFDocument document = new XWPFDocument(); //create table
XWPFTable table;
XWPFParagraph paragraph;
XWPFRun run;
XWPFTableRow rows = null;
XWPFTableCell cell = null;

//Write Hall Name at the top of the word document
paragraph = document.createParagraph();
run = paragraph.createRun();
run.setUnderline(UnderlinePatterns.WORDS);
run.setText("Hall Name: " + hallName);
run.addBreak();

table = document.createTable(rw, cl);
table.getCTTbl().getTblPr().unsetTblBorders();

for (int i=0; i<rw; i++) {
    rows = table.getRow(i);
    student = studentList.get(i);

    //First column
    cell = rows.getCell(0);
    paragraph = cell.addParagraph();
    run = paragraph.createRun();
    if (student.getImagePath() == null) {
        run.setText("Image Unavailable");
    } 
    else {
        fis = new FileInputStream(student.getImagePath());
        index = student.getImagePath().lastIndexOf('\\') + 1;
        imageName = student.getImagePath().substring(index);
        run.addPicture(fis, XWPFDocument.PICTURE_TYPE_JPEG, imageName, Units.toEMU(100), Units.toEMU(100));
    }

    //Second column
    cell = rows.getCell(1);
    paragraph = cell.addParagraph();
    run = paragraph.createRun();
    run.setText(details[0] + student.getRegNumber());
    run.addBreak();
    run.setText(details[1] + student.getName());
    run.addBreak();
    run.setText(details[2] + student.getExamNumber());
    run.addBreak();
    run.setText(details[3] + student.getTableNumber());
    run.addBreak();
    run.setText(details[4] + student.getLevel());
}
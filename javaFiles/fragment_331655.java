int pageW = 500;
int pageH = 1000;
int pageM = 100;

CTDocument1 ctDoc = document.getDocument();
CTBody body = ctDoc.getBody();
if (!body.isSetSectPr()) {
    CTSectPr section = body.addNewSectPr();
    if (!section.isSetPgSz()) {
        CTPageSz size = section.addNewPgSz();
        size.setW(BigInteger.valueOf(pageW));
        size.setH(BigInteger.valueOf(pageH));
    }

    if (!section.isSetPgMar()) {
        CTPageMar margin = section.addNewPgMar();
        margin.setBottom(BigInteger.valueOf(pageM));
        margin.setTop(BigInteger.valueOf(pageM));
        margin.setLeft(BigInteger.valueOf(pageM));
        margin.setRight(BigInteger.valueOf(pageM));
    }
}

XWPFParagraph paragraph = document.createParagraph();
XWPFRun run = paragraph.createRun();
String imgFile = "img.png";
FileInputStream fis = new FileInputStream(imgFile);
BufferedImage img = ImageIO.read(fis);
int width = img.getWidth();
int height = img.getHeight();
double scaling = 1.0;
if (width > pageW - 2*pageM) {
    scaling = ((double)(pageW - 2*pageM)) / width;
}
run.addPicture(new FileInputStream(imgFile), 
        XWPFDocument.PICTURE_TYPE_PNG, 
        imgFile, 
        Units.toEMU(width * scaling / 20), 
        Units.toEMU(height * scaling / 20));
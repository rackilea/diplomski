public static void main(String[] args) throws FileNotFoundException, IOException, XmlException{
    // create doc
    XWPFDocument document = new XWPFDocument();

    // some sample text
    document.createParagraph().createRun().setText("This is a Test.");

    // check to add footnotes in case of empty
    if (document.getFootnotes().isEmpty()){
        document.createFootnotes();
    }

    // add footnote
    CTFtnEdn ctfInstance = CTFtnEdn.Factory.newInstance();

    BigInteger id = new BigInteger("1");

    ctfInstance.setId(id);
    CTP ctp = ctfInstance.addNewP();

    ctp.addNewPPr().addNewPStyle().setVal("FootnoteText");

    CTR ctr = ctp.addNewR();
    ctr.addNewRPr().addNewRStyle().setVal("FootnoteReference");
    ctr.addNewFootnoteRef();

    CTText cttext = ctp.addNewR().addNewT();
    cttext.setStringValue("This should be a footnote");
    cttext.setSpace(SpaceAttribute.Space.PRESERVE);

    // add footnote to document
    document.addFootnote(ctfInstance);

    // add reference to footnote at end of first paragraph
    ctr = document.getParagraphArray(0).getCTP().addNewR();
    ctr.addNewRPr().addNewRStyle().setVal("FootnoteReference");
    ctr.addNewFootnoteReference().setId(id);

    // styles

    // if styles dont already exist then create them
    if (document.getStyles()==null){
        document.createStyles();
    }

    CTStyle style = CTStyle.Factory.newInstance();
    style.setStyleId("FootnoteReference");
    style.setType(STStyleType.CHARACTER);
    style.addNewName().setVal("footnote reference");
    style.addNewBasedOn().setVal("DefaultParagraphFont");
    style.addNewUiPriority().setVal(new BigInteger("99"));
    style.addNewSemiHidden();
    style.addNewUnhideWhenUsed();
    style.addNewRPr().addNewVertAlign().setVal(STVerticalAlignRun.SUPERSCRIPT);

    // add style
    document.getStyles().addStyle(new XWPFStyle(style));

    style = CTStyle.Factory.newInstance();
    style.setType(STStyleType.PARAGRAPH);
    style.setStyleId("FootnoteText");
    style.addNewName().setVal("footnote text");
    style.addNewBasedOn().setVal("Normal");
    style.addNewLink().setVal("FootnoteTextChar");
    style.addNewUiPriority().setVal(new BigInteger("99"));
    style.addNewSemiHidden();
    style.addNewUnhideWhenUsed();
    CTRPr rpr = style.addNewRPr();
    rpr.addNewSz().setVal(new BigInteger("20"));
    rpr.addNewSzCs().setVal(new BigInteger("20"));

    // add style
    document.getStyles().addStyle(new XWPFStyle(style));

    style  = CTStyle.Factory.newInstance();
    style.setCustomStyle(STOnOff.X_1);
    style.setStyleId("FootnoteTextChar");
    style.setType(STStyleType.CHARACTER);
    style.addNewName().setVal("Footnote Text Char");
    style.addNewBasedOn().setVal("DefaultParagraphFont");
    style.addNewLink().setVal("FootnoteText");
    style.addNewUiPriority().setVal(new BigInteger("99"));
    style.addNewSemiHidden();
    rpr = style.addNewRPr();
    rpr.addNewSz().setVal(new BigInteger("20"));
    rpr.addNewSzCs().setVal(new BigInteger("20"));

    // add style
    document.getStyles().addStyle(new XWPFStyle(style));

    // save document
    FileOutputStream out = new FileOutputStream(new File("yourPathHere.docx"));
    document.write(out);
    out.close();
}
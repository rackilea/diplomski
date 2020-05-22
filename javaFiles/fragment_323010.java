CTStyle style = CTStyle.Factory.newInstance();
style.setStyleId("FootnoteReference");
style.setType(STStyleType.CHARACTER);
style.addNewName().setVal("footnote reference");
style.addNewBasedOn().setVal("DefaultParagraphFont");
style.addNewUiPriority().setVal(new BigInteger("99"));
style.addNewSemiHidden();
style.addNewUnhideWhenUsed();
style.addNewRPr().addNewVertAlign().setVal(STVerticalAlignRun.SUPERSCRIPT);

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

document.getStyles().addStyle(new XWPFStyle(style));
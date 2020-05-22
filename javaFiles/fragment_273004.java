private static void createHyperLink(XWPFParagraph start, String startTxt, String endTxt) {

        // Creating the hyperlink in the start paragraph
        CTHyperlink cLink = start.getCTP().addNewHyperlink();

        // Link to the end text in the doc
        cLink.setAnchor(endTxt);

        // Creating the String that will have the hyperlink
        CTText ctText = CTText.Factory.newInstance();
        ctText.setStringValue(startTxt);
        CTR ctr=CTR.Factory.newInstance();
        ctr.setTArray(new CTText[]{ctText});

        // Inserting the String in the doc
        cLink.setRArray(new CTR[]{ctr});            
    }
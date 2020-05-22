public static XWPFDocument MergeDocument(XWPFDocument source, XWPFDocument output){

        for(IBodyElement element : source.getBodyElements()) {
           if(element instanceof XWPFParagraph) {
                XWPFParagraph paragraph = (XWPFParagraph)element;
                if(paragraph.getStyleID()!=null){
                    XWPFStyles styles= output.createStyles();
                    XWPFStyles stylesdoc2= source.getStyles();
                    styles.addStyle(stylesdoc2.getStyle(paragraph.getStyleID()));
                }    
                XWPFParagraph x= output.createParagraph();
                x.setStyle(((XWPFParagraph) element).getStyle());
                XWPFRun runx=x.createRun();
                runx.setText(((XWPFParagraph) element).getText());
            }
        }
return output;
    }
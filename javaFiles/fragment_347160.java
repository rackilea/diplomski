private Integer iBodyElementIterator (XWPFDocument wordDoc,String targetWordString) {
    Iterator<IBodyElement> iter = wordDoc.getBodyElementsIterator();
    Integer bodyElementID = null;
    while (iter.hasNext()) {
       IBodyElement elem = iter.next();
       bodyElementID = wordDoc.getBodyElements().indexOf(elem);
       if (elem instanceof XWPFParagraph) {

           XWPFParagraph paragraph = (XWPFParagraph) elem;
           for (XWPFRun runText : paragraph.getRuns()) {
                String text = runText.getText(0);                               
               Core.getLogger("WordExporter").trace("Body Element ID:  " + bodyElementID + " Text: " + text);
                if (text != null && text.equals(targetWordString)) {                        
                    break;                          
                }
            }

       } else if (elem instanceof XWPFTable) {
           if (((XWPFTable) elem).getRow(0) != null && ((XWPFTable) elem).getRow(0).getCell(0) != null) {
                // the first cell holds the name via the template
                String tableTitle = ((XWPFTable) elem).getRow(0).getCell(0).getText();
                if (tableTitle.equals(targetWordString)) {
                    break;
                }
                Core.getLogger("WordExporter").trace("Body Element ID:  " + bodyElementID + " Text: " + tableTitle);
           } else {
               Core.getLogger("WordExporter").trace("Body Element ID:  " + bodyElementID + " Table removed!");
           }

       }
       else {
           Core.getLogger("WordExporter").trace("Body Element ID:  " + bodyElementID + " Text: ?");
       }
    }
    return bodyElementID;
}
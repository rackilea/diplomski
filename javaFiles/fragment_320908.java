/* Replaces table */
private long replaceTable(XWPFDocument doc, ArrayList<String> qs, ArrayList<String> avgScores, ArrayList<String> favScores) {
    XWPFTable table = null;
    long count = 0;
     for (XWPFParagraph paragraph : doc.getParagraphs()) {
       List<XWPFRun> runs = paragraph.getRuns();
         String find = "%TABLE";
         TextSegement found = paragraph.searchText(find, new PositionInParagraph());
         if ( found != null ) {
           count++;
           if ( found.getBeginRun() == found.getEndRun() ) {
             // whole search string is in one Run
             XmlCursor cursor = paragraph.getCTP().newCursor();
             table = doc.insertNewTbl(cursor);
             XWPFRun run = runs.get(found.getBeginRun());
             // Clear the "%TABLE" from doc
            String runText = run.getText(run.getTextPosition());
            String replaced = runText.replace(find, "");
            run.setText(replaced, 0);
           } else {
             // The search string spans over more than one Run
             StringBuilder b = new StringBuilder();
             for (int runPos = found.getBeginRun(); runPos <= found.getEndRun(); runPos++) {
               XWPFRun run = runs.get(runPos);
               b.append(run.getText(run.getTextPosition()));
             }                       
             String connectedRuns = b.toString();
             XmlCursor cursor = paragraph.getCTP().newCursor();
             table = doc.insertNewTbl(cursor);
             String replaced = connectedRuns.replace(find, ""); // Clear search text

             // The first Run receives the replaced String of all connected Runs
             XWPFRun partOne = runs.get(found.getBeginRun());
             partOne.setText(replaced, 0);
             // Removing the text in the other Runs.
             for (int runPos = found.getBeginRun()+1; runPos <= found.getEndRun(); runPos++) {
               XWPFRun partNext = runs.get(runPos);
               partNext.setText("", 0);
             }
           }
         }     
     }
     fillTable(table, qs, avgScores, favScores);
     return count;
}
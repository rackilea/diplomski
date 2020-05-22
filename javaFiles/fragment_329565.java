final int maxRowCountPerPage = 44;
final int maxLettersPerLineInDescr = 55;
int totalRowCount = 0;

WordprocessingMLPackage mainTemplate = getWp();

//Iterate over projects
for (Project project : getProjects()) {
  WordprocessingMLPackage template = this.getWpProject();
  String projectDescription = project.getDescr();

  //Fill template...

  //Count the lines
  int rowsInProjectDescr = (int) Math.floor((double) projectDescription.length() / maxLettersPerLineInDescr);
  int projectRowCount = 0;
  List<Object> tables = doc.getAllElementFromObject(template.getMainDocumentPart(), Tbl.class);
  for (Object table : tables) {
    List<Object> rows = doc.getAllElementFromObject(table, Tr.class);
    int tableRowCount = rows.size();
    projectRowCount += tableRowCount;
  }
  //System.out.println("projectRowCount before desc:" + projectRowCount);
  projectRowCount += rowsInProjectDescr;
  //System.out.println("projectRowCount after desc:" + projectRowCount);
  totalRowCount += projectRowCount;
  //System.out.println("totalRowCount: " + totalRowCount);

  //Break page if too many lines for page
  if (totalRowCount > maxRowCountPerPage) {
    addPageBreak(wp);
    totalRowCount = projectRowCount;
  }
  //Add project template to main template
  for (Object table : tables) {
    mainTemplate.getMainDocumentPart().addObject(table);
  }
}
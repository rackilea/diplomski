// create your second jasper print
JasperPrint jasperPrint = JasperFillManager.fillReport(..., ..., ...);

List<JRPrintPage> listPages = jasperPrint.getPages();
int numberOfPages = listPages.size();
int currentPageIndex = 1;
for (JRPrintPage currentPage : listPages) {
    List listElements = currentPage.getElements();

    for (Object element : listElements) {
        if (element instanceof JRTemplatePrintText) {
            JRTemplatePrintText templatePrintText = (JRTemplatePrintText) element;
            // set currrent page
            if (templatePrintText.getKey() != null
                    && templatePrintText.getKey().equalsIgnoreCase("textFieldCurrentPage")) {
                    templatePrintText.setText(String.valueOf(lastPageNumber + currentPageIndex));
            }
        }
    }
    currentPageIndex++;
}
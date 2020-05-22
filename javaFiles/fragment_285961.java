JRPrintPage page1 = jasperPrint1.getPages().get(0);
List<JRPrintPage> pages2 = jasperPrint2.getPages();
for (JRPrintPage page : pages2) {
   List<JRPrintElement> elements = page.getElements();
   for (JRPrintElement element : elements) {
     page1.addElement(element);
   }
}
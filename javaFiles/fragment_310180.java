System.out.println("listIterator(PDPage)");
ListIterator<PDPage> pageIterator = listIterator(document.getPage(0));
while (pageIterator.hasNext()) {
    PDPage page = pageIterator.next();
    System.out.println("page #: " + pageIterator.previousIndex() + ", Structural Parent Key: " + page.getStructParents());
}
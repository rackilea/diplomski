ListIterator<PDPage> pageIterator = listIterator(document.getPage(3));
pageIterator.next();
while (pageIterator.hasPrevious()) {
    PDPage page = pageIterator.previous();
    System.out.println("page #: " + pageIterator.nextIndex() + ", Structural Parent Key: " + page.getStructParents());
}
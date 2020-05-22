File file = new File("Files/catalog.xml");
DocumentContainer dc = new DocumentContainer(file.toURI().toURL());
JXPathContext ctx = JXPathContext.newContext(dc);
Iterator iter = ctx.iterate("//cd/artist");
//In this case, following API will return DOM object
//Iterator iter = ctx.selectNodes("//cd/artist").iterator();
while (iter.hasNext()) {
    System.out.println(iter.next());//object type is String
}
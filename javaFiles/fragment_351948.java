// untested
JXPathContext context = JXPathContext.newContext(myMap);
Iterator iter = context.iterate("FIRST_LIST/SECOND_LIST/MY_MAP/MY_PRIMITIVE");
while (iter.hasNext()) {
    String str = (String) iter.next();
    // do something with strings
}
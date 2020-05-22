Builder builder = new Builder();
nu.xom.Document doc = builder.build(documentFile);
context = XPathContext.makeNamespaceContext(doc.getRootElement());
Nodes nodes = doc.getRootElement().query("w:body/*", context);
for (int i = 0; i < nodes.size(); i++) {
    transform((nu.xom.Element) nodes.get(i));
}
...

private void transform(nu.xom.Element node){
    //process nodes
    ...
}
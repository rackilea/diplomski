XPathExpression expr = xpath.compile("//table/table_column/column[col_alt='SALE DATE']/@name");
Object result = expr.evaluate(doc, XPathConstants.NODESET);

NodeList nodes = (NodeList) result;
for (int i = 0; i < nodes.getLength(); i++) {
    System.out.println(nodes.item(i).getNodeValue());
}
public static void main(String[] args) throws Exception {
    Parser parser = new Parser("file:test.html");
    CssSelectorNodeFilter cssFilter = new CssSelectorNodeFilter("td[class=\"xx\"]");
    NodeList nodes = parser.parse(cssFilter);
    String[][] resultSet = new String[nodes.size()][2];
    for (int i=0;i<nodes.size();i++) {
        Node n = nodes.elementAt(i);
        System.out.println(n); // DEBUG remove me!
        resultSet[i][0]=n.toPlainTextString().trim();
        resultSet[i][1]=null;
        Node c = n.getFirstChild();
        while( c!=null ) {
            if( c instanceof LinkTag ) {
                resultSet[i][1] = ((LinkTag) c).getLink();
                break;
            }
            c = c.getNextSibling();
        }

        System.out.println(i+" text :"+resultSet[i][0]); // DEBUG remove me!
        System.out.println(i+" link :"+resultSet[i][1]); // DEBUG remove me!
    } 
}
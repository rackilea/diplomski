import bsh.Node; //you need this as well

public String perform() throws ParseException, IOException {
    FileInputStream sourceStream = new FileInputStream(sourseFilePath);
    Parser p = new Parser(sourceStream);

    while (!p.Line()) {
        recursive_print(p.popNode(), "");
    }

    sourceStream.close();
    return "";
}

public void recursive_print(Node node, String prefix)
{
    System.out.println(prefix + node.getText());
    for (int i=0; i<node.jjtGetNumChildren(); i++)
        recursive_print(node.getChild(i), prefix+"  ");
}
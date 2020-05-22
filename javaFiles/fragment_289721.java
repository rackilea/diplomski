// removed returnStr as a parameter
private static String getAP(BinaryNodeInterface<Character> root, String path) 
{
    String returnStr = "" + root.getData() + " " + path + "\n";
    if(root.hasLeftChild())
        returnStr += getAP( root.getLeftChild(), path.concat("0")); 
    if(root.hasRightChild())
        returnStr += getAP( root.getRightChild(), path.concat("1"));

    return returnStr;
}
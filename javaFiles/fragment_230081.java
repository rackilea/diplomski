private Node locate(String p, Node famTree)
{
    Node result = null;
    if (famTree == null)
        return null;
    if (famTree.value.equals(p))
        return famTree;
    if (famTree.left != null)
        result = locate(p,famTree.left);
    if (result == null)
        result = locate(p,famTree.right);
    return result;

}
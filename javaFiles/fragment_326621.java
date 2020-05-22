if(root.left != null)
{
    MTE prev = tempElement;
    while(tempElement.left != null) {
         prev = tempElement;
         tempElement = tempElement.left;
    }

    if(tempElement.right == null)  prev.left = null;
    else prev.left = tempElement.right;
}
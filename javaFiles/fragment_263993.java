public void insert(String aLabel)
{
    if(getLabel().compareTo(aLabel) <= 0)
        if(childrenLeft == null)
            childrenLeft = new BSTreeNode(aLabel, this);
        else
            childrenLeft.insert(aLabel);
    else
        if(childrenRight == null)
            childrenRight = new BSTreeNode(aLabel, this);
        else
            childrenRight.insert(aLabel);
}
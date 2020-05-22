while(element.compareTo(child.value) != 0)
{
    if(child == null)
    {
        System.out.println("Element not found.");
        return;
    }
    else if(element.compareTo(child.value) < 0)
    {
        parent = child;
        child = child.leftChild;
    }
    else 
    {
        parent = child;
        child = child.rightChild;
    }
}
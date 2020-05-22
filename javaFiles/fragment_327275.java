public int getNumberOfNodes(TreeModel model)  
{  
    return getNumberOfNodes(model, model.getRoot());  
}  

private int getNumberOfNodes(TreeModel model, Object node)  
{  
    int count = 1;
    int nChildren = model.getChildcount(node);  
    for (int i = 0; i < nChildren; i++)  
    {  
        count += getNumberOfNodes(model, model.getChild(node, i));  
    }  
    return count;  
}
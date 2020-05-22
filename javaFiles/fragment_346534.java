void addElement(elem, root)
{
    if (elem < root.value) {  
      if(!root.hasLeft())
          root.setLeft(newNode);
      else
          addElement(elem, root.getLeft());
    }
    else {    
      if(!root.hasRight())   
          root.setRight(newNode);
      else             
          addElement(elem, root.getRight());
    }
}
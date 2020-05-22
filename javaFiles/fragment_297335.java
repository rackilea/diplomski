boolean inorderInsert(BTree<E> T, E x) {
    BTreeNode<E> n = T.getRoot();
    if(T.getRoot() == null) {
        T.setRoot(new BTreeNode<E>(x));
    }


    while (n != null) {
        if (x.equals(n.getElement()))                            
        return false;                                                             
else if (x.compareTo(n.getElement()) < 0)                  
        if (n.getLeftChild() == null) {                            
        n.setLeftChild(new BTreeNode<E>(x));                      
        return true;                                              
        }           
        else         
        n = n.getLeftChild();                                                                                                    
else  if (n.getRightChild() == null){                            
        n.setRightChild(new BTreeNode<E>(x));                   
        return true;                                               
        }
        else   
        n = n.getRightChild();                                  
        }
        return false;                                              
        }
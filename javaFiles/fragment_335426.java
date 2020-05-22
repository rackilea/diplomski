while(true)
     { 
        parent=current; //assign parent to root
        if(n.compareTo(current.s.retname())<0) 
        {
             current=current.lchild; 
             if(current==null) {//added brackets so the return only happened when this was true
               parent.lchild=newNode;
               return;
            }
       }
       else
       { 
        current=current.rchild;
        if(current==null){ //added brackets so the return only happened when this was true
            parent.rchild=newNode;
            return;
            }
        }
   }
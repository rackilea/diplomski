public void insertNode(T d) { 


    if(root==null){
        root= new TreeNode<T>(d); 
        size+=1;    

    }
    else if(root!=null){
        genList(root);
        if(needsChildren(nodesThatNeedChildren.get(0))){
            if(nodesThatNeedChildren.get(0).left==null){
                nodesThatNeedChildren.get(0).left= new TreeNode<T>(d);
                size+=1;
            }else{
                nodesThatNeedChildren.get(0).right= new TreeNode<T>(d);
                size+=1;
            }
        }else{
            while(!needsChildren(nodesThatNeedChildren.get(0))){
                nodesThatNeedChildren.remove(0);

            }

            if(nodesThatNeedChildren.get(0).left==null){
                nodesThatNeedChildren.get(0).left = new TreeNode<T>(d);
                size+=1;
            }else{
                nodesThatNeedChildren.get(0).right = new TreeNode<T>(d);
                size+=1;
            }
        }
    }




}
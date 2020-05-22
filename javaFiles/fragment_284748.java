public boolean getPath(root, value){
    if(root == null){
        return false;
    }
    if(root.value === value){
        System.out.println(root.value);
        return true;
    }
    int onPath = getPath(root.left, value);
    if(onPath){
        System.out.println(root.value);
        return true;
    }
    onPath = getPath(root.right,value);
    if(onPath){
        System.out.println(root.value);
        return true;
    }
    return false; //a path was never found
}
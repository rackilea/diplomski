public void convert (TreeNode<E> node){
    StringBuilder builder = new StringBuilder();
    for(int i = 1; i <= size(); i++){
        if (i % 2 == 0){
            builder.append("0");
        }
        else{
            builder.append("1");
        }
    }
    String myBinaryString = builder.toString();
}
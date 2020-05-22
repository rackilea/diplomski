protected TreeNode insertItem(TreeNode r, String word) {
//base case
if(r==null){
 r =   new TreeNode(new WordRefs(word));
    }
else if(word.compareTo(r.item.getWord()) <= 0){
    r.left = insertItem(r.left, word);
}else{
    r.right = insertItem(r.right, word);
}
return r;
}
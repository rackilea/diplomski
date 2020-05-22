public TreeNode<T> next() {
Treenode<t> ret = preorder.pop();

for (int i = ret.getChildren().size()-1 ; i>=0; i--) {
            preorder.push(ret.getChildAt(i));

        }
return ret;

}
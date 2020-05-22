public static TreeNode<CharFreq> buildTree(ArrayList<TreeNode<CharFreq>> trees)
    throws IOException {
    Comparator<TreeNode<CharFreq>> comparator = new Comparator<TreeNode<CharFreq>>() {

        //basic implementation, you must use your own!
        public int compare(TreeNode<CharFreq> node1, TreeNode<CharFreq> node2) {
            return node1.data.compareTo(node2.data);
        }
    };
    PriorityQueue<TreeNode<CharFreq>> pq = new PriorityQueue<TreeNode<CharFreq>>(10, comparator);
    //the rest of your code...
}
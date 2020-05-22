List<String> input1 = new ArrayList<String>();
List<String> input2 = new ArrayList<String>();

Position<Integer> left = tree.left(tree.root());
Position<Integer> right = tree.right(tree.root());

traverse(left, input1, true);
traverse(right, input2, false);
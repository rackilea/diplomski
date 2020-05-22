class BinTreeIterator implements Iterator<BinTreeNode> {
    Stack<BinTreeNode> stack;
    boolean leftToRight;

    public boolean hasNext() {
        return !stack.empty();
    }

    public BinTreeNode next() {
        return stack.peek();
    }

    public void remove() {
        BinTreeNode node = stack.pop();
        if (leftToRight) {
            node = node.rightChild;
            while (node.rightChild != null) {
                stack.push(node);
                node = node.rightChild;
            }
        } else {
            node = node.leftChild;
            while (node.leftChild != null) {
                stack.push(node);
                node = node.leftChild;
            }
        }
    }

    public BinTreeIterator(BinTreeNode node, boolean leftToRight) {
        stack = new Stack<BinTreeNode>();
        this.leftChildToRight = leftToRight;

        if (leftToRight) {
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
        } else {
            while (node != null) {
                stack.push(node);
                node = node.rightChild;
            }
        }            
    }
}



public static boolean searchNumBinTree(BinTreeNode node, int num) {
    if (node == null)
        return false;

    BinTreeIterator leftIter = new BinTreeIterator(node);
    BinTreeIterator rightIter = new BinTreeIterator(node);

    while (leftIter.hasNext() && rightIter.hasNext()) {
        BinTreeNode left = leftIter.next();
        BinTreeNode right = rightIter.next();
        int sum = left.item + right.item;
        if (sum == num) {
            return true;
        } else if (sum > num) {
            rightIter.remove();
            if (!rightIter.hasNext() || rightIter.next() == left) {
                return false;
            }
        } else {
            leftIter.remove();
            if (!leftIter.hasNext() || leftIter.next() == right) {
                return false;
            }
        }
    }

    return false;
}
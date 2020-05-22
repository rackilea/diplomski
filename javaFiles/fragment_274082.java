public Iterator<V> iterator() {
        return new Itr();
    }

    private class Itr<V> implements Iterator<V> {
        TreeNode<V> localNode = (TreeNode<V>) root;
        Stack<TreeNode<V>> stack;

        public Itr() {
            stack = new ArrayStack<TreeNode<V>>();

            while (localNode != null) {
                stack.push(localNode);
                localNode = localNode.getLeftChield();
            }
        }

        public boolean hasNext() {
            return !stack.empty();
        }

        public V next() {
            TreeNode<V> node = stack.pop();
            V v = node.getValue();
            if (node.getRightChield() != null) {
                node = node.getRightChield();
                while (node != null) {
                    stack.push(node);
                    node = node.getLeftChield();
                }
            }
            return v;
        }

        public void remove() {
            throw new UnsupportedOperationException();

        }

    }
public void keepBranch(T param) {

        for (Node<T> node : this.root.children) {
            if (param.equals(node.data)) {
                this.root = node;
            }
        }
}
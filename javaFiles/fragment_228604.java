public void add(int x) {
    if (this.root == null) {
        this.root = new Node(x);
    } else {
        r = this.root;
        if (x > r.info) {
             while (r != null && x > r.info) {
                 r = r.right;
             }

             r.right = new Node(x);
        }
        // similarly for x < root.info, etc.
}
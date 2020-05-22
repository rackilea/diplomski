public String inOrder() {
    String asc = "";
    if (this.left != null) {
        asc += this.left.inOrder();
    }

    asc = asc + this.value + " ";

    if (this.right != null) {
        asc += this.right.inOrder();
    }
    return asc;
}
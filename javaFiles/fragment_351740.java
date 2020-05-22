if (current.left != null) {
    current=current.left;
    prev.key=current.key;
    prev.left = current.left;
    this.repaint();
}
else {
    current=current.right; //this might be null
 ...
}
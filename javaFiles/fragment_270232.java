public void add(int num) {
    root = add(num, root);
}

private Node add(int num, Node t) {
    if (t == null)
        return t = new Node(num);
    else if (t.getLeftSon() == null)
        t.setLeftSon(new Node(num));
    else if (t.getRightSon() == null)
        t.setRightSon(new Node(num));
    else if (Math.abs(height(t.getLeftSon()) - height(t.getRightSon())) <= 1)
        t.setLeftSon(add(num, t.getLeftSon()));
    else
         t.setRightSon(add(num, t.getRightSon()));
    return t;
}
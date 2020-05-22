public boolean insert(Node r, int x) {
    if (r == null) {
        r = new Node(x);
        return true;
    }
    else{
        if (r.info == x) {
            System.out.println("the value has already been added");
            return false;
    }
        if (r.info < x)
            insert(r.left, x);
        if (r.info > x)
            insert(r.right, x);
    }

    return false;
}
interface Composite {
    void attachToLeft(Node newParent);
    void attachToRight(Node newParent);
}

class Leaf implements Composite { 
    public String val;
    @Override
    public void attachToLeft(Node newParent) {
        newParent.left = this;
    }
    @Override
    public void attachToRight(Node newParent) {
        newParent.right = this;
    }
}

class Node implements Composite {
    private Node parent;
    private Composite left;
    private Composite right;

    public void attachLeft(Composite c) {
         c.attachToLeft(this);
    }
    public void attachRight(Composite c) {
         c.attachToRight(this);
    } 
    @Override
    public void attachToLeft(Node newParent) {
         this.parent = newParent;
         newParent.left = this;
    }
    @Override
    public void attachToRight(Node newParent) {
         this.parent = newParent;
         newParent.right = this.
    }
}
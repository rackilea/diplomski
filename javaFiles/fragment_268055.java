private Integer count = 0;

private void setIds(Composite c) {
    Control[] children = c.getChildren();
    for(int j = 0 ; j < children.length; j++) {
        if(children[j] instanceof Composite) {
            setIds((Composite) children[j]);
        } else {
            children[j].setData(count);
            System.out.println(children[j].toString());
            System.out.println(" '-> ID: " + children[j].getData());
            ++count;
        }
    }
}
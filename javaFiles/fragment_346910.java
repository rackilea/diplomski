public final class MyDataNode extends DefaultMutableTreeNode {
    private final MyData myData;

    public MyDataNode(MyData myData) {
        this.myData = myData;
    }

    public MyData getMyData() {
        return myData;
    }
}
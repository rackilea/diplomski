public class MyStringBuilder {
    private CNode sentinel = new CNode('s');
    private CNode lastC = sentinel;
    private int length = 0;

    public MyStringBuilder(String s){
        append(s);
    }

    public void append(String s){
        for (int i = 1; i < s.length(); i++){
            CNode newNode = new CNode(s.charAt(i));
            lastC.next = newNode;
            lastC = newNode;
            length++;
        }
    }

    public CNode getHead(){
        return sentinel.next;
    }

    public CNode getTail(){
        if (length) {
            return lastC;
        } else {
            return null;
        }
    }
}
//toString in MyStack class
public String toString(){
    String s = "";
    Node temp = top;
    while(temp != null){
        s+= temp + " ";
        temp = temp.getNext();
    }
    return s;
}
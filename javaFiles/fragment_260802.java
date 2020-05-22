@Override
public String toString(){
    StringBuilder sb = new StringBuilder();
    LinkedNode current = front;
    while(current != null){
        sb.append(current.x + " "); //Not an ideal solution, but demonstrates the right idea.
        current = current.next;
    }
    return sb.toString();
}
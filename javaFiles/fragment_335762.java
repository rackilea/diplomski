public String toString(){
    StringBuilder temp = new StringBuilder();
    temp.append(this.letter); //assumes you always have at least one character to print
    LString curr = next;
    while (curr != null ){
        temp.append(curr.letter);
        curr = curr.next;
    }

    return temp.toString();
}
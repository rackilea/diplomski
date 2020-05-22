reverse(){
    Node current = this.head;
    int half = this.size/2;
    int midElement = this.size % 2 == 0 ? 0: half + 1;
    Stack<Node<E>> stack = new Stack<Node<E>>();

    for(int i = 0; i < this.size; i++){
        if (i < = half)
            stack.push(current);
        else{
            if (i == midElement)
                continue;
            else
                swap(stack.pop(), current);
        current = current.next;
    }
}

swap(Node<E> v, Node<E> v1){
    E tmp = v.value;
    v.value = v1.value;
    v1.value = tmp;
}
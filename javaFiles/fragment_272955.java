// a bit strange that you start with the "endNode", are you sure it is not "startNode"?
// and starting with next node will cause `endNode` itself to be skipped 
// and is going to cause problem if endNode itself is null
for(Node<T> current = endNode.getNext()
    ; current != null
    ; current = current.getNext()){
    input = input + current.toString() + "\n";  // bad idea to do string concat in loop, use StringBuilder instead

    endNode = current;  // this one makes no sense and did nothing meaningful
    current = current.getNext();  // this is already in for-loop, 
                                  // having this is going to
                                  // roll-forward 2 nodes each loop
}
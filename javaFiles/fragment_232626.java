FUNCTION findInsertionPoint(Node head, V value) RETURNS Node
  // return null if value needs to be inserted before head
  IF head == null OR value < head.getValue()
     RETURN null;

  // otherwise, either return a node with the given value,
  // or return a node after which value should be inserted
  Node curr = head;
  REPEAT
     IF curr.value == value
        RETURN curr;
     ELSEIF curr.getNext() == null OR curr.getNext().getValue() > value
        RETURN curr;
     ELSE
        curr = curr.getNext();

PROCEDURE insert(V value) {
  Node newNode = NEW Node(value);
  Node insertPoint = findInsertionPoint(this.head, value);
  IF insertPoint == null // insert before head
     newNode.setNext(this.head);
     this.head = newNode;
  ELSE
     IF insertPoint.getValue() == value
        insertPoint.incrementCounter();
     ELSE // insert after insertPoint
        newNode.setNext(insertPoint.getNext());
        insertPoint.setNext(newNode);
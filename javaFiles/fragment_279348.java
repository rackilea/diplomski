public class LinkedList {

private Node firstNode = null;

public LinkedList() {
}

public Node getFirstNode() {
    return firstNode;
}

public void setFirstNode(Node firstNode) {
    this.firstNode = firstNode;
}

public void addNode(Node node) {
    if(firstNode == null){
        firstNode = node;
    }else{
        Node walker = firstNode;
        while(walker.getNext() != null)
            walker = walker.getNext();
        walker.setNext(node);
    }
}

public void delete(int value) {
    if (firstNode != null) {
        Node walker = firstNode;
        if (walker.getValue() == value) {
            if(walker.getNext()!=null){
                firstNode = walker.getNext();
            }else{
                setFirstNode(null);
            }
        } else {
            Node previous = walker;
            while (walker.getNext() != null) {
                previous = walker;
                walker = walker.getNext();
                if (walker.getValue() == value) {
                    previous.setNext(walker.getNext());
                    break;
                }
            }
        }

    } else {
        System.out.println("Nothing to delete");
    }
}

public void listValues (){
    if(firstNode != null){
        Node walker = firstNode;
        while(walker.getNext() != null)
        {
            System.out.println(walker.getValue());
            walker = walker.getNext();

        }
    }
}
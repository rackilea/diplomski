public class Link {

    public static void main (String[] args) {
        LinkList theLinkedList = new LinkList();
        theLinkedList.insertFirstRequest(3);
        theLinkedList.insertFirstRequest(6);
        theLinkedList.insertFirstRequest(10);
        theLinkedList.insertFirstRequest(20);

        theLinkedList.display();
    }

    int floorRequested;

    Link next;

    Link(int floorRequested) {
        this.floorRequested = floorRequested;
    }

    public void display () {
        System.out.println(toString());
    }

    @Override
    public String toString () {
        return "Floor req: " + floorRequested;
    }
}

class LinkList {

    public Link firstRequest;

    LinkList() {
        firstRequest = null;
    }

    public boolean isEmpty () {
        return (firstRequest == null);
    }

    public void insertFirstRequest (int floorRequested) {
        Link newRequest = new Link(floorRequested);

        newRequest.next = firstRequest;

        firstRequest = newRequest;
    }

    public Link removeFirstRequest () {
        Link linkRef = firstRequest;

        if (!isEmpty()) {
            firstRequest = firstRequest.next;
        } else {
            System.out.println("No Requests");
        }
        return linkRef;
    }

    public void display () {
        Link theLink = firstRequest;

        while (theLink != null) {
            theLink.display();

            System.out.println("Next Request: " + theLink.next);
            theLink = theLink.next;

            System.out.println("");
        }
    }

    public Link find (int floorRequested) {
        Link theLink = firstRequest;

        if (!isEmpty()) {
            while (theLink.floorRequested != floorRequested) {
                if (theLink.next == null) {
                    return null;
                } else {
                    theLink = theLink.next;
                }
            }
        } else {
            System.out.println("No Requests");
        }
        return theLink;
    }

    public Link removeRequest (int floorRequested) {
        Link currenntRequest = firstRequest;
        Link previousRequest = firstRequest;

        while (currenntRequest.floorRequested != currenntRequest.floorRequested) {
            if (currenntRequest.next == null) {
                return null;
            } else {
                previousRequest = currenntRequest;
                currenntRequest = currenntRequest.next;
            }
        }
        if (currenntRequest == firstRequest) {
            firstRequest = firstRequest.next;
        } else {
            previousRequest.next = currenntRequest.next;
        }
        return currenntRequest;
    }

}
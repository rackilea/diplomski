public void add(int data) {
    Link newLink = new Link(data);
    if (first == null) {
        first = newLink;
        System.out.println(first.data);
        System.out.println(newLink);
    } else {
        first.next = newLink; // <-- This is wrong
        // first=newLink;
        System.out.println(newLink.data);
        // newLink = newLink.next;
        // newLink.next=newLink;
        last = newLink;

    }
    // newLink.next=first;//it copies the address of old first
    // last=newLink;
    System.out.println("end");
    System.out.println(last);
}
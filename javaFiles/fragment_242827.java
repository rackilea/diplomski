LinkedList<Integer> ll = new LinkedList<Integer>();
    ll.add(1);
    ll.add(2);
    ll.add(3);

    System.out.println("Normal traversal");
    for(Iterator<Integer> i = ll.iterator(); i.hasNext();) {
        System.out.println(i.next());
    }
    System.out.println("Reverse");
    for(Iterator<Integer> i = ll.descendingIterator(); i.hasNext();) {
        System.out.println(i.next());
    }
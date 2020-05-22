ObservableLinkedList<String> list = new ObservableLinkedList<>();
    list.addListener((Change<? extends String> c) -> {
        while (c.next()) {
            if (c.wasAdded()) {
                System.out.println("Added from "+c.getFrom()+" to "+c.getTo()+" "+c.getAddedSubList());
            }
            if (c.wasRemoved()) {
                System.out.println("Removed from "+c.getFrom() + " to "+c.getTo()+" "+c.getRemoved());
            }
            if (c.wasUpdated()) {
                System.out.println("Updated");
            }
            if (c.wasPermutated()) {
                System.out.println("Permutated");
            }
        }
    });
    list.addAll("Two", "Three", "Four");
    list.offerFirst("One");
    list.offer("Five");
    System.out.println(list.pollFirst());
    System.out.println(list.pollLast());
// we create new `LinkedList` as a backing queue and decorate it
ListenableQueue<String> q = new ListenableQueue<>(new LinkedList<>());

// register a listener which polls a queue and prints an element 
q.registerListener(e -> System.out.println(q.poll()));

// voila!
q.add("record1");
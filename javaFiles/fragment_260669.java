Leaf b1 = new Leaf(5);
Leaf b2 = new Leaf(5);
Node b = new Node(b1, b2);
Leaf c1 = new Leaf(3);
Leaf c2 = new Leaf(7);
Node c = new Node(c1, c2);
Node a = new Node(b, c);
System.out.println("a value = " + a.getValue());
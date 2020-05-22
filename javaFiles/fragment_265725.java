public static LinkedList concatenateLL(LinkedList l, LinkedList m) {
   LinkedList a = new LinkedList();

   // copy Nodes, you need to create new instance of them
   for ( int i = 0; i < l.getNumberOfNodes(l.getHeadNode()); ++i )
        a.insertLast( l.getNode( i ) );

   // copy Nodes, you need to create new instance of them
   for ( int i = 0; i < m.getNumberOfNodes(m.getHeadNode()); ++i )
        a.insertLast( m.getNode( i ) );

   return a;
}
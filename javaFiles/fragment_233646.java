while(fr.hasNextLine()) {
   int nodeId1 = fr.nextInt();
   int nodeId2 = fr.nextInt();
   Vertex<Integer> vert1 = null;
   Vertex<Integer> vert2 = null;

   for(Vertex<Integer> v : g.vertices()) {
      int nodeId = v.element();
      if(nodeId == nodeId1) 
         vert1 = v;
      else if (nodeId == nodeId2) // assumes can't have nodeId1 == nodeId2
         vert2 = v;
    }
    if (vert1 == null)
       vert1 = g.insertVertex(nodeId1);
    if (vert2 == null)
       vert2 = g.insertVertex(nodeId2);

    g.insertEdge(vert1, vert2, null);
 }
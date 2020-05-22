// lookup existing person1 by userId
 GraphTraversalSource g = titanGraph.traversal();
 Vertex person1 = g.V().has("userId", 1).next();

 // create person3
 Vertex person3 = titanGraph.addVertex("Person");
 person3.property("userId", 3);
 person3.property("username", "cde");

 // create edge from person1 to person3
 Edge knows = person1.addEdge("Knows", person3);
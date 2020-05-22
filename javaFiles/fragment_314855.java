[...]
Graph g = new Graph(edges);
g.calculateShortestDistances(5,8);
g.calculatePath();

String results =  "";

ArrayList<Integer> path = g.getPath();

System.out.println(path);
[...]
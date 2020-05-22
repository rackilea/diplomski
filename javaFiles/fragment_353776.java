WeightedGraph<String, DefaultEdge> g = new SimpleWeightedGraph<String, DefaultEdge>(DefaultEdge.class);

String odp = "ODP";
String cck = "CCK";
String mfe = "MFE";

g.addVertex(odp);
g.addVertex(cck);
g.addVertex(mfe);

DefaultEdge e1 = g.addEdge(odp, cck);
DefaultEdge e1 = g.addEdge(odp, mfe);

g.setEdgeWeight(e1, 10);
g.setEdgeWeight(e2, 4);
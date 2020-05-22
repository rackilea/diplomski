gremlin> g = new TinkerGraph()
==>tinkergraph[vertices:0 edges:0]
gremlin> v1 = g.addVertex()
==>v[0]
gremlin> v2 = g.addVertex()
==>v[1]
gremlin> v3a = g.addVertex()
==>v[2]
gremlin> v3b = g.addVertex()
==>v[3]
gremlin> v4 = g.addVertex() 
==>v[4]
gremlin> v1.addEdge('next',v2)
==>e[5][0-next->1]
gremlin> v2.addEdge('next',v3a)
==>e[6][1-next->2]
gremlin> v2.addEdge('next',v3b)
==>e[7][1-next->3]
gremlin> v3a.addEdge('next',v4)
==>e[8][2-next->4]                 
gremlin> g.v(1).out.loop(1){it.object.outE.hasNext()}
==>v[3]
==>v[4]
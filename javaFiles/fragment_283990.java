gremlin> g = new TinkerGraph()
==>tinkergraph[vertices:0 edges:0]
gremlin> src = g.addVertex(null)
==>v[0]
gremlin> src.setProperty("name",1) 
==>null
gremlin> src.setProperty("Type", "switch")
==>null
gremlin> src1 = g.addVertex(null)
==>v[1]
gremlin> src1.setProperty("name",2)
==>null
gremlin> src1.setProperty("Type", "switch")
==>null
gremlin> src2 = g.addVertex(null)
==>v[2]
gremlin> src2.setProperty("name",3)
==>null
gremlin> src2.setProperty("Type", "switch")
==>null
gremlin> src3 = g.addVertex(null)
==>v[3]
gremlin> src3.setProperty("name",4)
==>null
gremlin> src3.setProperty("Type", "switch")
==>null
gremlin> e=g.addEdge(null, src, src1, "connects")
==>e[4][0-connects->1]
gremlin> e1= g.addEdge(null, src1, src2, "connects")
==>e[5][1-connects->2]
gremlin> e2= g.addEdge(null, src2, src3, "connects")
==>e[6][2-connects->3]
gremlin> g.V.has('name',1).out.loop(1){it.object.name != 4 && it.loops < 5}{true}.path.filter{it.last().name == 4}
==>[v[0], v[1], v[2], v[3]]
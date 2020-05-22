gremlin> g = TinkerGraphFactory.createTinkerGraph()
==>tinkergraph[vertices:6 edges:6]
gremlin> g.v(1).as('x').out.gather.scatter.loop('x'){true}{true}
==>v[2]
==>v[4]
==>v[3]
==>v[5]
==>v[3]
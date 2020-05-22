gremlin> g = TinkerGraphFactory.createTinkerGraph()
==>tinkergraph[vertices:6 edges:6]
gremlin> t=new Tree();g.v(1).out.tree(t).loop(2){true}
gremlin> t
==>v[1]={v[2]={}, v[3]={}, v[4]={}}
==>v[4]={v[3]={}, v[5]={}}
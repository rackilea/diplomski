gremlin> graph = TitanFactory.open('inmemory'); g = graph.traversal()
==>graphtraversalsource[standardtitangraph[inmemory:[127.0.0.1]], standard]
gremlin> v = graph.addVertex('name','jenny','places','home')
==>v[4264]
gremlin> g.V(v).properties('places').hasValue('home')
==>vp[places->home]
gremlin> g.V(v).properties('places').hasValue('home').property('phone','867-5309'); 'traversal was not iterated'
==>traversal was not iterated
gremlin> g.V(v).properties('places').hasValue('home').properties()
gremlin> g.V(v).properties('places').hasValue('home').property('phone','867-5309').iterate(); 'iterated!'
==>iterated!
gremlin> g.V(v).properties('places').hasValue('home').properties()
==>p[phone->867-5309]
gremlin> graph.tx().commit()
==>null
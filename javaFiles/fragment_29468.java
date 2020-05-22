gremlin> g = TinkerFactory.createModern().traversal()
==>graphtraversalsource[tinkergraph[vertices:6 edges:6], standard]
gremlin> g.addV().property('name','cat').
......1>   addV().property('name','dog').
......2>   addV().property('name','person').iterate()
gremlin> markoRelations = [['has','dog'],['has','cat'],['is','person']];[]
gremlin> joshRelations = [['has','dog'],['is','person']];[]
gremlin> t = g.V().has('name','marko').as('from');[]
gremlin> markoRelations.each { t = t.V().has('name',it[1]).
......1>                             addE(it[0]).from('from') };[]
gremlin> t.iterate()
gremlin> t = g.V().has('name','josh').as('from');[]
gremlin> joshRelations.each { t = t.V().has('name',it[1]).
......1>                            addE(it[0]).from('from') };[]
gremlin> t.iterate()
gremlin> g.E().hasLabel('is','has')
==>e[19][1-has->15]
==>e[20][1-has->13]
==>e[21][1-is->17]
==>e[22][4-has->15]
==>e[23][4-is->17]
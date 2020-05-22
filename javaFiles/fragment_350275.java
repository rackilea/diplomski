//copy all properties
MATCH (n:TestX), (m:TestX) WHERE n.name = m.name AND ID(n)<ID(m) WITH n, m SET n += m;

//copy all outgoing relations
MATCH (n:TestX), (m:TestX)-[r:TEST]->(endnode) WHERE n.name = m.name AND ID(n)<ID(m) WITH n, collect(endnode) as endnodes
FOREACH (x in endnodes | CREATE (n)-[:TEST]->(x));

//copy all incoming relations
MATCH (n:TestX), (m:TestX)<-[r:TEST]-(endnode) WHERE n.name = m.name AND ID(n)<ID(m) WITH n, collect(endnode) as endnodes
FOREACH (x in endnodes | CREATE (n)<-[:TEST]-(x));

//delete duplicates
MATCH (n:TestX), (m:TestX) WHERE n.name = m.name AND ID(n)<ID(m) detach delete m;
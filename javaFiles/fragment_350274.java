CREATE (n1:TestX {name:'A', val1:1})
CREATE (n2:TestX {name:'B', val2:2})
CREATE (n3:TestX {name:'B', val3:3})
CREATE (n4:TestX {name:'B', val4:4})
CREATE (n5:TestX {name:'C', val5:5})

MATCH (n6:TestX {name:'A', val1:1}) MATCH (m7:TestX {name:'B', val2:2}) CREATE (n6)-[:TEST]->(m7)
MATCH (n8:TestX {name:'C', val5:5}) MATCH (m10:TestX {name:'B', val3:3}) CREATE (n8)<-[:TEST]-(m10)
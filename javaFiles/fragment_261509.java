payload = {"list":[{"a":"Name1","b":"Name2"},{"a":"Name3","b":"Name4"}]}

statement = "UNWIND {list} AS d "
statement += "MATCH (A:Person {name: d.a}) "
statement += "MATCH (B:Person {name: d.b}) " 
statement += "MERGE (A)-[:KNOWS]-(B) "

tx = session.begin_transaction()
tx.run(statement,payload)
tx.commit()
// Peter meets Paul
MERGE (peter:User {name:"Peter"})
MERGE (paul:User {name:"Paul"})
MERGE (peter)-[m:MEETS]-(paul)
    ON CREATE SET m.timestamp = [timestamp()]
    ON MATCH SET m.timestamp = m.timestamp + timestamp()
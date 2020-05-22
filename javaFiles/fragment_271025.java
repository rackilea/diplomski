MATCH 
(u:User {uuid:{userUuid}}),
(l:Library {uuid:{libraryUuid}}),
(u)-[:CAN_ACCESS]->(b:Book),
(l)-[:CONTAINS]-(b)
RETURN b
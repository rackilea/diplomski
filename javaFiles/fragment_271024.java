MATCH (u:User), (l:Library)
WHERE 
ID(u) = {userId} AND ID(u) = {libraryId}
MATCH 
(u)-[:CAN_ACCESS]->(b:Book),
(l)-[:CONTAINS]-(b)
RETURN b
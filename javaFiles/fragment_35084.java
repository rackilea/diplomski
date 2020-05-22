MATCH (user1:User), (user2:User)
MATCH
  (user1)-[:BOOKED_RIDE]->(ride1:Ride),
  (user2)-[:BOOKED_RIDE]->(ride2:Ride),
  (start1)<-[start_rel1:STARTS_AT]-(ride1)-[end_rel1:ENDS_AT]->(end1),
  (start2)<-[start_rel2:STARTS_AT]-(ride2)-[end_rel2:ENDS_AT]->(end2)
WITH 
  [
    {grid_item: start1, time: start_rel1.time},
    {grid_item: end1, time: end_rel1.time},
    {grid_item: start2, time: start_rel2.time},
    {grid_item: end2, time: end_rel2.time}
  ] AS stops
UNWIND stops AS stop
WITH stop
ORDER BY stop.time
RETURN collect(stop) AS stops
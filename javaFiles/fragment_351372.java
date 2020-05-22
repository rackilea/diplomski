MATCH (a:Student)-[r:TARGET]->(t:Student) WHERE r.uuid = $uuid
/* Lets Kill the student and set confirmed to true */
SET r.confirmed = true, t.IsDead = true 
/* Delete any teachers that may have the target of the student*/
WITH a, t, r
MATCH (t)<-[tr:TARGET]-(:Teacher) DELETE r
/* Get the assassinated persons target. Set them as X. */
WITH a, t
MATCH (t)-[ar:TARGET]->(x:Student) WHERE ar.confirmed = false AND x.IsDead = false
/* Lets deal with anyone who inherited our target if we are dead :(*/
OPTIONAL MATCH (t)<-[sr:TARGET]-(ss:Student) WHERE sr.confirmed = false AND ss.IsDead = false
/* Lets steal their kill node and set them as our new target unless of course someone decided to kill us and nab them */
WITH COALESCE(t, a) as n, t
CREATE (n)-[nr:TARGET {killed:false,confirmed:false}]->(t)
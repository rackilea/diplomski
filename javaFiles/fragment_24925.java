MATCH (:page {name:'engg'})-[:ownerof]->(n:lectureseries)
OPTIONAL MATCH (n)-[:seriesof]->(l1:lecture)
WHERE l1.privacy='public' or l1.privacy='follower'
WITH n, COUNT(l1) as lecturecount1
OPTIONAL MATCH (n)-[:seriesof]->(l2:lecture)<-[:privileged]-(:user{name:'Ann'})
RETURN n.series_name as name, lecturecount1 + COUNT(l2) AS lecturecount
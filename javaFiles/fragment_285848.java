// this is the expensive operation, to order millions of authors by id
// still, do it and take the top 25
MATCH (a:author) WITH a order by a.id LIMIT 25
// find publications for the top 25 authors
MATCH (a)<-[:publishedby]-(p)
// return aggregation
RETURN a.id, p.year, p.type, count(*)
LIMIT 25;
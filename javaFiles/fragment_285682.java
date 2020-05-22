PREFIX mdb: <http://data.linkedmdb.org/resource/movie/film>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> 
select ?label ?film
where {
  service <http://data.linkedmdb.org/sparql> {
    ?film mdb:id ?uri .
    ?film rdfs:label ?label . 
    filter regex(?label, "Batman")
  }
}
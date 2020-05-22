prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>

select distinct ?class where {
  { ?class a rdfs:Class } union
  { ?class rdfs:subClassOf|^rdfs:subClassOf [] }
}
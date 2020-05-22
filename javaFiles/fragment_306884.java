prefix owl: <http://www.w3.org/2002/07/owl#>
prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>

select ?s ?p ?o where {
  ?s ?p ?o .

  #-- don't include object or datatype properties    
  filter not exists {
    values ?type { owl:ObjectProperty owl:DatatypeProperty }
    ?p a ?type 
  }

  #-- don't include properties from rdf: or owl: namespaces  
  filter( !strstarts( str(?p), str(rdf:) ) )
  filter( !strstarts( str(?p), str(owl:) ) )

  #--  don't include rdfs: properties used in OWL to RDF mapping
  filter( ?p not in ( rdfs:range, rdfs:domain, rdfs:subClassOf, rdfs:subPropertyOf ) )
}
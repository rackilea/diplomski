prefix :      <http://stackoverflow.com/q/22396095/1281433/intersections#>
prefix rdfs:  <http://www.w3.org/2000/01/rdf-schema#>
prefix owl:   <http://www.w3.org/2002/07/owl#>
prefix xsd:   <http://www.w3.org/2001/XMLSchema#>
prefix rdf:   <http://www.w3.org/1999/02/22-rdf-syntax-ns#>

select ?class ?i where {
  values ?i { :A :B :C :D :E }
  ?class owl:equivalentClass/
         owl:intersectionOf/
         rdf:rest*/rdf:first ?i .

  filter not exists { 
    ?class owl:equivalentClass/
           owl:intersectionOf/
           rdf:rest*/rdf:first ?j .
    filter( !(?j in (:A, :B, :C, :D, :E )) )
  }
}
order by ?class ?i
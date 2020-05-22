prefix :      <http://stackoverflow.com/q/22396095/1281433/intersections#>
prefix owl:   <http://www.w3.org/2002/07/owl#>
prefix rdf:   <http://www.w3.org/1999/02/22-rdf-syntax-ns#>

select ?class ?i where {
  ?class owl:equivalentClass/
         owl:intersectionOf ?list .
  ?list rdf:rest*/rdf:first/(owl:equivalentClass|^owl:equivalentClass)* ?i .
  filter( ?i in (:A, :B, :C, :D, :E ))

  filter not exists { 
    ?list rdf:rest*/rdf:first ?element .
    filter not exists {
      ?element (owl:equivalentClass|^owl:equivalentClass)* ?j
      filter( ?j in (:A, :B, :C, :D, :E ))
    }
  }
}
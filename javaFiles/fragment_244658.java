prefix :      <http://stackoverflow.com/q/22396095/1281433/intersections#>
prefix owl:   <http://www.w3.org/2002/07/owl#>
prefix rdf:   <http://www.w3.org/1999/02/22-rdf-syntax-ns#>

select ?class ?i where {
  # find each ?class that's equivalent to an intersection
  ?class owl:equivalentClass/owl:intersectionOf ?list .

  # and grab the intersecting classes for the results
  ?list rdf:rest*/rdf:first ?i .

  # but filter out any ?class that has an intersecting
  # class that's not in the input list.
  filter not exists { 
    ?list rdf:rest*/rdf:first ?element .
    filter( !(?element in (:A, :B, :C, :D, :E )) )
  }
}
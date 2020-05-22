@prefix :      <http://stackoverflow.com/q/22396095/1281433/intersections#> .
@prefix rdfs:  <http://www.w3.org/2000/01/rdf-schema#> .
@prefix owl:   <http://www.w3.org/2002/07/owl#> .
@prefix xsd:   <http://www.w3.org/2001/XMLSchema#> .
@prefix rdf:   <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .

<http://stackoverflow.com/q/22396095/1281433/intersections>
        a       owl:Ontology .

:A      a       owl:Class .
:B      a       owl:Class .
:C      a       owl:Class .
:D      a       owl:Class .
:E      a       owl:Class .
:F      a       owl:Class .

:ABC    a                    owl:Class ;
        owl:equivalentClass  [ a                   owl:Class ;
                               owl:intersectionOf  ( :A :B :C )
                             ] .

:CDE    a                    owl:Class ;
        owl:equivalentClass  [ a                   owl:Class ;
                               owl:intersectionOf  ( :C :D :E )
                             ] .

:DEF    a                    owl:Class ;
        owl:equivalentClass  [ a                   owl:Class ;
                               owl:intersectionOf  ( :D :E :F )
                             ] .
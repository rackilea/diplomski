:Z      a       owl:Class ;
        owl:equivalentClass :B .

:AZC    a                    owl:Class ;
        owl:equivalentClass  [ a                   owl:Class ;
                               owl:intersectionOf  ( :A :Z :C )
                             ] .
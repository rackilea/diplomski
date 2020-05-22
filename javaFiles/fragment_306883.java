prefix  owl: <http://www.w3.org/2002/07/owl#>

select ?s ?p ?o where { 
  ?s ?p ?o .
  ?p a owl:AnnotationProperty .
}
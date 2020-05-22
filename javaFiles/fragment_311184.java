prefix : <urn:train:>
prefix xsd: <http://www.w3.org/2001/XMLSchema#>
prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>

select * where {
  ?train :name ?name ;
         :description ?description ;
         :arrival ?arrival ;
         :departure ?departure ;
         :destination ?destination .
  optional {
    ?train :over/(rdf:rest*/rdf:first) ?over
  }
}
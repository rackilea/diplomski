prefix : <urn:train:>
prefix xsd: <http://www.w3.org/2001/XMLSchema#>

select * where {
  ?train :name ?name ;
         :description ?description ;
         :arrival ?arrival ;
         :departure ?departure ;
         :destination ?destination .
  optional {
    ?train :over ?over
  }
}
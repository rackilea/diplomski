prefix : <urn:train:>
prefix xsd: <http://www.w3.org/2001/XMLSchema#>

select ?train ?name ?description
       ?arrival ?departure
       ?destination
       (group_concat(?over) as ?overs)
where {
  ?train :name ?name ;
         :description ?description ;
         :arrival ?arrival ;
         :departure ?departure ;
         :destination ?destination .
  optional {
    ?train :over ?over
  }
}
group by ?train ?name ?description ?arrival ?departure ?destination
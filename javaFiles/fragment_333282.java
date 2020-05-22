prefix xsd: <http://www.w3.org/2001/XMLSchema#>
prefix my: <http://www.semanticweb.org/rohit/ontologies/2014/4/untitled-ontology-20#>

select ?Email ?ind ?ind1 where {
   #-- The values block just binds ?_Email, ?_ind, and ?_ind1 
   #-- to the original output that you were getting.  You'd still
   #-- have your original query text here.
   values (?_Email ?_ind ?_ind1) {
     ("5"^^xsd:decimal my:HotelCityPark "Hotel"^^xsd:string)
   }

   bind( xsd:integer(?_Email) as ?Email )
   bind( strafter(str(?_ind),str(my:)) as ?ind  )
   bind( str(?_ind1) as ?ind1 )
}
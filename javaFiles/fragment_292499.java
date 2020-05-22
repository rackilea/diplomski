[ {
  "@id" : "http://example.com/ontology",
  "@type" : [ "http://www.w3.org/2002/07/owl#Ontology" ]
}, {
  "@id" : "http://example.com/ontology#Person",
  "@type" : [ "http://www.w3.org/2002/07/owl#Class" ]
}, {
  "@id" : "http://example.com/ontology#Woman",
  "@type" : [ "http://www.w3.org/2002/07/owl#Class" ],
  "http://www.w3.org/2000/01/rdf-schema#subClassOf" : [ {
    "@id" : "http://example.com/ontology#Person"
  } ]
} ]
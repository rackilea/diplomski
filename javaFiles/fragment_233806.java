PREFIX : <http://semanticweb.org/sensor#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
SELECT ?sensor
WHERE {
  ?sensor :hasId "55"^^xsd:int
}
PREFIX skos:<http://www.w3.org/2004/02/skos/core#>
SELECT ?a
WHERE
{ ?o skos:prefLabel ?a .
  FILTER REGEX(?a, 'e', 'i').
}
ORDER BY ?a
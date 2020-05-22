SELECT ?position    
WHERE {     
    ?s rdf:type esco:Occupation.                   # (1)
    ?position skos:prefLabel|skos:altLabel ?label  # (2)
    FILTER (lcase(?label)="acuponcteur"@fr ) 
}
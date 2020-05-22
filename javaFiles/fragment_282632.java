<!-- results of: construct where { <http://dbpedia.org/resource/Mount_Monadnock> a ?type } limit 5 -->
<rdf:RDF
    xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
    xmlns:owl="http://www.w3.org/2002/07/owl#"
    xmlns:j.1="http://schema.org/"
    xmlns:j.0="http://dbpedia.org/ontology/"
    xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#">
  <owl:Thing rdf:about="http://dbpedia.org/resource/Mount_Monadnock">
    <rdf:type rdf:resource="http://dbpedia.org/ontology/Mountain"/>
    <rdf:type rdf:resource="http://dbpedia.org/ontology/Place"/>
    <rdf:type rdf:resource="http://schema.org/Mountain"/>
    <rdf:type rdf:resource="http://dbpedia.org/ontology/NaturalPlace"/>
  </owl:Thing>
</rdf:RDF>

<!-- results of: construct where { <http://dbpedia.org/resource/Mount_Monadnock> <http://dbpedia.org/ontology/locatedInArea> ?place } limit 5 -->
<rdf:RDF
    xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
    xmlns:dbpedia-owl="http://dbpedia.org/ontology/"
    xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#">
  <rdf:Description rdf:about="http://dbpedia.org/resource/Mount_Monadnock">
    <dbpedia-owl:locatedInArea rdf:resource="http://dbpedia.org/resource/United_States"/>
    <dbpedia-owl:locatedInArea rdf:resource="http://dbpedia.org/resource/Dublin,_New_Hampshire"/>
    <dbpedia-owl:locatedInArea rdf:resource="http://dbpedia.org/resource/New_Hampshire"/>
    <dbpedia-owl:locatedInArea rdf:resource="http://dbpedia.org/resource/Cheshire_County,_New_Hampshire"/>
    <dbpedia-owl:locatedInArea rdf:resource="http://dbpedia.org/resource/Jaffrey,_New_Hampshire"/>
  </rdf:Description>
</rdf:RDF>

<!-- combined results -->
<rdf:RDF
    xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
    xmlns:owl="http://www.w3.org/2002/07/owl#"
    xmlns:dbpedia="http://dbpedia.org/resource/"
    xmlns:schema="http://schema.org/"
    xmlns:dbpedia-owl="http://dbpedia.org/ontology/">
  <schema:Mountain rdf:about="http://dbpedia.org/resource/Mount_Monadnock">
    <dbpedia-owl:locatedInArea rdf:resource="http://dbpedia.org/resource/Dublin,_New_Hampshire"/>
    <dbpedia-owl:locatedInArea rdf:resource="http://dbpedia.org/resource/New_Hampshire"/>
    <rdf:type rdf:resource="http://www.w3.org/2002/07/owl#Thing"/>
    <rdf:type rdf:resource="http://dbpedia.org/ontology/Mountain"/>
    <dbpedia-owl:locatedInArea rdf:resource="http://dbpedia.org/resource/Jaffrey,_New_Hampshire"/>
    <dbpedia-owl:locatedInArea rdf:resource="http://dbpedia.org/resource/Cheshire_County,_New_Hampshire"/>
    <rdf:type rdf:resource="http://dbpedia.org/ontology/Place"/>
    <rdf:type rdf:resource="http://dbpedia.org/ontology/NaturalPlace"/>
    <dbpedia-owl:locatedInArea rdf:resource="http://dbpedia.org/resource/United_States"/>
  </schema:Mountain>
</rdf:RDF>
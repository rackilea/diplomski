@prefix owl:     <http://www.w3.org/2002/07/owl#> .
@prefix xsd:     <http://www.w3.org/2001/XMLSchema#> .
@prefix rdf:     <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .

<x-model://a/class>
      a       owl:Class .

<x-model://a>
      a       owl:Ontology .


x-model://a after
-------------------------------------------
@prefix rdfs:    <http://www.w3.org/2000/01/rdf-schema#> .
@prefix owl:     <http://www.w3.org/2002/07/owl#> .
@prefix xsd:     <http://www.w3.org/2001/XMLSchema#> .
@prefix rdf:     <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .

<x-model://a/class>
      a       owl:Class .

<x-model://a>
      a       owl:Ontology .


x-model://b
-------------------------------------------
@prefix rdfs:    <http://www.w3.org/2000/01/rdf-schema#> .
@prefix owl:     <http://www.w3.org/2002/07/owl#> .
@prefix xsd:     <http://www.w3.org/2001/XMLSchema#> .
@prefix rdf:     <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .

<x-model://b/individual>
      a       <x-model://a/class> .

<x-model://b>
      a       owl:Ontology ;
      owl:imports <x-model://a> .
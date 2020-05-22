PREFIX :<http://www.ontotext.com/connectors/lucene#>
  PREFIX inst:<http://www.ontotext.com/connectors/lucene/instance#>
  INSERT DATA {
    inst:labelFR-copy :createConnector '''
  {
    "fields": [
      {
        "indexed": true,
        "stored": true,
        "analyzed": true,
        "multivalued": true,
        "fieldName": "label",
        "propertyChain": [
          "http://www.w3.org/2000/01/rdf-schema#label"
        ],
        "facet": true
      }
    ],
    "types": [
      "urn:MyClass"
    ],
    "stripMarkup": false,
    "analyzer": "org.apache.lucene.analysis.fr.FrenchAnalyzer"
  }
  ''' .
  }
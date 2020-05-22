curl -X POST -H 'Content-type:application/json' --data-binary '{
  "add-field-type" : {
     "name":"phoneStripped",
     "class":"solr.TextField",
     "positionIncrementGap":"100",
     "analyzer" : {
        "charFilters":[{
           "class":"solr.PatternReplaceCharFilterFactory",
           "replacement":"",
           "pattern":"[^a-zA-Z0-9]"
        }],
        "tokenizer":{
           "class":"solr.KeywordTokenizerFactory" 
        },
     }
  }
}' http://localhost:8983/solr/foo/schema
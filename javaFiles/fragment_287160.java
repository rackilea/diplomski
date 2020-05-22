curl -XGET http://localhost:9200/myindex/date-test/_search?pretty -d '
{  
 "query":{  
   "match_all":{ }
 },
 "script_fields":{  
   "aDate":{  
      "script":"use( groovy.time.TimeCategory ) { new Date( doc[\"aDate\"].value )  }"
   }
 }
}'
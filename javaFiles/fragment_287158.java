curl -XGET http://localhost:9200/myindex/date-test/_search?pretty -d '
{
 "fields" : "aDate",
 "query":{  
   "match_all":{  

   }
 }
}'
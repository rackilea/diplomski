POST index/_search
{
    "query": {
        "query_string": {
           "query": "_type:server_physical AND cpu:(*2620* AND *E5* AND *v3*)",
           "lowercase_expanded_terms": false
        }
    }
}
POST /twitter/tweet/_search?search_type=dfs_query_then_fetch
{
        "explain": true, 
        "query": {
                "term" : {
                        "title" : "d"
                }
        }
}
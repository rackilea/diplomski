{
    "from" : 0,
    "size" : 30,
    "query" : {
        "query_string" : {
            "query" : "*jhon*",
            "default_field" : "_all"
        }
    },
    "filter" : {
        "term" : { 
            "activated" : "true" 
        }
    },
    "sort" : [ 
        {
            "id" : {
                "order" : "desc"
            }
        }
    ]
}
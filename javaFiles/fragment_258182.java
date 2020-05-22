{
    "bool" : {
        "must" : { "term" : { "component" : "comp_1" } },
        "should" : [
            { "term" : { "userId" : "A1A1" } },
            { "term" : { "customerId" : "C1" } },
            { "term" : { "currentRole" : "ADMIN" } }
        ],
        "minimum_should_match" : 1
    }
}
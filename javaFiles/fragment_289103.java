{
    "filter" : { 
        "bool" : {
            "should" : [  
                { "terms" : { "status" : [ "{{#ProductIDs}}","{{.}}","{{/ProductIDs}}"] }} 
                {{^ProductIDs}},
                {"match_all":{}}
                {{/ProductIDs}}
            ]
        }
    }
}
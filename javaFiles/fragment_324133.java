{ "_id" : { "$oid" : "525b048580c3fb0d62d2b6fc"} , <-- Document
  "city" : "London" , 
  "currentWeather" : [                             <-- Array
                         { "cloudcover" : "25",    <-- Sub document
...etc...
                           "pressure" : "1008" , 
                           "temp_C" : "11",
                           "temp_F" : "52", 
...etc...
                         }
                     ]
}
jooq 
    { 
      generator 
        { generate 
           { relations = true 
             deprecated = false 
             records = true 
             immutablePojos = false 
             daos = false 
             fluentSetters = true 
       } 
      target { packageName = '...' }
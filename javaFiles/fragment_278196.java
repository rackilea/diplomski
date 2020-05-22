db.gasstation.update(    
    //Query to get the position
    { 
      "prices.fuelType":  "DIESEL"  
    },
    // Use the positional $ operator to update specific element (which matches your query    
    { 
      $set: 
          { 
            "prices.$" : 
              //Element/new value to update
               {
                 "fuelType" : "DIESEL",
                 "price" : 999.7
               } 
          } 
    } 
);
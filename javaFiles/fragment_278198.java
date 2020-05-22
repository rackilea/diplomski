db.gasstation.update(    
    //Query to match
    {
      "address.city":"Bangalore",
      "brand":"Shell",
      "countrycode":"in",
      "prices": { $exists: true }
    },
    // Use $set operator & overwrite entire array
    { 
      $set: 
          { 
            //Overwrite value
            "prices" : [
                {
                    "fuelType" : "DIESEL",
                    "price" : 502.7
                }, 
                {
                    "fuelType" : "PETROL",
                    "price" : 607.05
                }
              ] 
          } 
    } 
);
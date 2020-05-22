db.gasstation.update(    
    //Query to get the position
    { 
      "prices.fuelType":  "DIESEL"  
    },
    // Use the positional $ operator to update specific element (which matches your query    
    { 
      $set: 
          { 
            //set value specific to elements field/key
            //i.e. Update documents in an Array
            "prices.$.price" : 999.7 
          } 
    } 
);
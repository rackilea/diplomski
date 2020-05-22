[
  {
    "operation": "shift",
    "spec": {
      "*": { // loop thru the outer array
        // each item of the outer array, is an array
        // match individual array indicies, and then send them to the 
        //  output with the nice name.
        "0": "[&1].policyReference",
        "1": "[&1].insuredId",
        "2": "[&1].insuredName" 
        // etc
      }
    }
  }
]
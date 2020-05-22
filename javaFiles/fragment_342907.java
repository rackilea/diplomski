...
pay(apiRequest)
     .subscribe(onSuccesValue -> {
             // The whole chain was successful and this is the value returned 
             // by the last observable in the chain (doConfirmationLogic in your case)
      }, onError {
             // There was an error at some point during the chain
      }
...
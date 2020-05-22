if (!resObject.isEmpty()){
      GenericMessage<?> firstMessage = resObject.iterator().next();
      Object first = firstMessage.getObject();
      if (first instanceof Client){
         // do Client stuff
      }else if (first instanceof SearchResponse){
         // do SearchResponse
      }else if (first instanceof Collection){
         // blah
      }else{
         // error?
      }
 }
.thenAccept(i -> 
     {
      if(i.isPresent()){
         deleteItem(event, i.get());
      }
     });
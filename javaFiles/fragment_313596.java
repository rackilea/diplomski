if(amountEntered != null){
      amntEntered = Double.parseDouble(amountEntered);  
      // Because you are comparing amountEntered to "" and you check if it's null
      //I assume it is of type String which means that you can't cast it to a double.
}else if(!amountEntered.equals("")){ 
        // if it gets past the first check
        // it means that amountEntered is null and this will produce a NullPointerException
    amntEntered = Double.parseDouble(amountEntered);
}else if((amountEntered == null || amountEntered.equals(""))){
        // Here if amountEntered is null, the second check will
        // still be executed and will produce a NullPointerException
        // When you use || both the check before || and after || are executed
    System.out.print("");    
}
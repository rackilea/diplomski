if(amountEntered != null && !amountEntered.isEmpty()){
   try{
      someDoubleVariable = Double.parseDouble(amountEntered);
   }catch(NumberFormatException e){
      someDoubleVariable = 0;
      e.printStackTrace()
   }
}else if(amountEntered==null || (amountEntered!=null && amountEntered.isEmpty())){
     someDoubleVariable = 0;
}
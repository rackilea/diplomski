double result;
 try{
   result = Double.parseDouble(nf.format(relationship));
 }catch(NumberFormatException e){
   e.printStackTrace();
   result = 0.0;
 }
 return result;
try{
 while(getRow_Method_Result.next()){
    row_result.add(getRow_Method_Result.getString(1));
    row_result.add(getRow_Method_Result.getString(2));
    row_result.add(getRow_Method_Result.getString(3));
    row_result.add(getRow_Method_Result.getString(4)); 
  }
} catch(Exception e){
  //Do not leave this blank!!! you must handle exception here !
  // At least do e.printStackTrace(); to see exception during development. 
}
int[] myNumbers = new int[tempList.length];
for(int i = 0; i < tempList.length; i++){
  try{
     myNumbers[i] = Integer.parseInt(tempList[i]); 
  }catch(Exception E){
     myNumbers[i] = -1; 
  }
}
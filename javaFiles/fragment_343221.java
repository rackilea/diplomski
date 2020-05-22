for(String element:container){
  try {
    int num = Integer.parseInt(element); 
    sum += num;
  catch (NumberFormatException nfe){
    System.out.println ("Element " + element + " in the array is not an integer");
  }
}
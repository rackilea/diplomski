for (int i = yearInt; i != checkNumber; checkNumber--){
     checkNumber = resultYear%10;
     System.out.println (checkNumber);// In here you are just giving it the initial value again.
     System.out.println (i);
     resultYear = resultYear -1; 
     System.out.println (resultYear);
}
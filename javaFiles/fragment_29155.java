char a = x.charAt(input);        
  System.out.println(a);

 int y= Character.getNumericValue(a);

  if (y==0){
    System.out.println ("+1 Zero");
    zero++;
}
else if (y%2 == 0 && y>1){
    System.out.println("+1 Even");
    even++;
}
else {
    System.out.println("+1 Odd");
    odd++;
}
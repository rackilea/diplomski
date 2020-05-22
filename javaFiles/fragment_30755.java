// Is the input not valid? Return a bad result
if(!s.matches("(\\d+,)*\\d+")){
  System.out.print("Bad input ");
  int[] emptyArray = {};
  return emptyArray;
}
java.uti.ArrayList<String> equation = java.util.Arrays.asList({"2","-","2","+","5"});
java.util.Iterator<String> equIterator = equation.iterator();
int result = 0;
int multiplier = 1;
while(equIterator.hasNext()){
     String operandOrOperator = equIterator.next();
     if(operandOrOperator.equals("+")){
          multiplier=1;
     }else if(operandOrOperator.equals("-")){
          multiplier=-1;
     }else if(operandOrOperator.equals("*")){
          result*=Integer.parseInt(equIterator.next()); // Assuming that next element will be there always after operator.
     }else{
          result+=(multiplier * Integer.parseInt(operandOrOperator));
     }
}
System.out.println("Final result : " + result);
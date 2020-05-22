public <IntegerA extends Integer, IntegerB extends Integer>
   List<IntegerA> func(List<IntegerA> A, List<IntegerB> B){
       ArrayList result = new ArrayList();

       //A and B have the same length
       for(int index = 0; index < A.length();index++){

           //Decide if a gets added to result based on the corresponding B
           if(decisionFunction(B.get(i)){
               result.add(A.get(i));
           }
       }

       return result;
}
UnaryOperator<Integer> f =
    type == 1 ? 
        computeIteration
        : computeRecursion;

System.out.println( f.apply(enterNumber) ) ;
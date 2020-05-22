public static Integer sum(Integer[] x) {
    Integer result = 0;
    for(int i = 0; i < x.length; i++)
        result += x[i];
    return result;
}

public static void main(String[] args) {
    Integer[] arr = {1,2,3,4,5};
    System.out.println(doSomething(Play::sum, arr));
}

public static Integer doSomething(Function<Integer[], Integer> func,
                                  Integer[] arr) {        
    return func.apply(arr);
}
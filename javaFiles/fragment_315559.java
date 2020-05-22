public static void main(String[] args) {
    List<Long> list = generateFibonacci(10, 5);
    System.out.println(list.size());     
    System.out.println(Arrays.toString(list.toArray()));     
}

public static List<Long>  generateFibonacci(long limit, long startPoint) {
    List<Long> list = new ArrayList<>();

    long first = 0;
    long second = 1;
    long endPoint = startPoint + limit - 1;
    //System.out.print(first + ", " + second);
    if (startPoint==0){
            list.add(0);
            list.add(1);
    }else if (startPoint ==1){
            list.add(1);
    }
    for (long i = 2; i < endPoint; i++) {
        long next = first + second;
        if (i > startPoint) {
            // System.out.println(next);
            list.add(next);
        }

        first = second;
        second = next;
    }

    return list;
}
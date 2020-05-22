public static void main(String[] args) {
    recusiveFunction(1,10); // First parameter is the iteration number and 2 is total times.
}

private static void recusiveFunction(int iteration ,int total) {
    String str="";
    for(int i=1;i<=iteration;i++){ // this loops creates what it needs to print 1 or 12 or 123
        str+=i;
    }
    if(iteration<total/2){
        System.out.println(str);
        recusiveFunction(++iteration,total);
    }
    System.out.println(str);
}
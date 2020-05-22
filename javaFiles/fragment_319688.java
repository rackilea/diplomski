public static void main(String[] args) {
    recusiveFunction(1,10,"");
}

private static void recusiveFunction(int iteration ,int total, String str) {
    str+=iteration;
    if(iteration<total/2){
        System.out.println(str);
        recusiveFunction(++iteration,total,str);
    }
    System.out.println(str);
}
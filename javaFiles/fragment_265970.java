public static int sum(int... args) {
    int sum = 0;
    for (int arg : args)
        sum += arg;
    return sum;
}
public static double average(int... args) {
     return (sum(args)/(float)args.length);
}
public static void main(String []args){
    System.out.println("Average: "+average(4,3,6,1));
}
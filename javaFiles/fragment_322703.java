public static void main(String[] args) {
    int[] my_Numbers= {1789, 2035, 1899, 1456, 2013,
            1458, 2458, 1254, 1472, 2365,
            1456, 2165, 1457, 2456};
    for(int i=0; i < my_Numbers.length-1;){
        if (Integer.compare(my_Numbers[i],my_Numbers[(i+1)])==1) {
            int x = my_Numbers[i];
            my_Numbers[i] = my_Numbers[i+1];
            my_Numbers[i+1] = x;
            i=0;
        }else {i++;}
    }
    String  result= Arrays.toString(my_Numbers);
    System.out.println(result);
}
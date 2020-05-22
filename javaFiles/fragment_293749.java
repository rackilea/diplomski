static long i = 0l;
public static String someMethod(){
    String accm = "";
    for(;i < Integer.MAX_VALUE*20/*Just to make sure word tearing occurs*/; i++)
        accm += i
    return accm;
}
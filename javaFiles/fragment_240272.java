class Junk {
    public static final int j ;
    static {
        // Use java.lang.Properties here to get the values 
        j = 42;
    }

    public static void main(String[] argv){
        System.out.printf("The answer is %d\n"  , j);
    }
}
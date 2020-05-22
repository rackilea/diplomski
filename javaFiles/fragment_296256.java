public class Test {
    public static void main(String[] args) {
        int initalValue = 200 ;
        int finalValue = 1000 ;
        int range = finalValue - initalValue;
        int designCalRange = range/4;
        System.out.println("Dividing in to 5 equal intervals");
        System.out.println(initalValue);
        for (double i = 1; i<=3;i++){
            System.out.println((int)(initalValue+designCalRange));
            initalValue = initalValue+ designCalRange;
        }
        System.out.println(finalValue);
    }
}
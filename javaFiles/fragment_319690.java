public class Main {
    private  static int iteration=1;
    private  static String str ="";

    public static void main(String[] args) {
        printSequence(10);
    }

    private static void printSequence(int total) {
        if(iteration<=total){
            str+=iteration;
            System.out.println(str);
            iteration++;
            printSequence(total);
        }
        if(2*total - iteration >0) {
            str = str.substring(0, 2 * total - iteration);
            iteration++;
            System.out.println(str);
        }
    }
}
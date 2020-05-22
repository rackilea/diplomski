import java.util.Scanner;

    public class ScannerDemo {

    public static void main(String args[]){
        String s = "Hello World|I am bob|how are you ";
        Scanner scan = new Scanner(s);
        scan.useDelimiter("\\|");
        System.out.println(scan.next());
        while (scan.hasNext()){
            System.out.println(scan.next());
        }

    }
}
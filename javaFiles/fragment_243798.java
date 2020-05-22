public class Test {
    public static void main(String[] args) {
        int c = 1;
        do { 
            int d =1;
            do{
                System.out.print(c);
                d++;
            } while (c>=d);
            System.out.println("");
        c++;        
        }
        while (c<10);
    }
}
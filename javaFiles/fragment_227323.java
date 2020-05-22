public class AddExtra{
    public static void main(String[] args) {
        Add a = new Add(); // Here, the constructor is run

        int b = 5;
        int c = a.c + b; // Access "a.c" because "c" is a public variable now

        System.out.println(c);
    }   
}
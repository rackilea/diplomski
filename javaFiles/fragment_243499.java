import static java.lang.System.out;

public class App {
    public static int hash(float x, float y, float z) {
        double hash = (((x * 31) + (y * 37) + (z * 41)));//31,37 and 41 are prime numbers
        return (int) (hash);//multiplying the hash by 1000 for example may increase the accuracy significantly. Depends on the size of your space
    }

    public static void main(String[] args) {
        for (float count = 0; count < 2; count += 0.01) {
            out.println(hash(0, 0, count));
        }
    }

}
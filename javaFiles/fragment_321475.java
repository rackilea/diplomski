import java.util.Scanner;

public class test {
    public static void main (String[] args){
        Film[] f = new Film[10];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 10; i++){
            f[i] = new Film();

            System.out.println("Enter Title:");
            f[i].setTitle(input.next());

            System.out.println("Enter Film Length:");
            f[i].setLength(input.nextDouble());
        }
        input.close();

        for (int i = 0; i < 10; i++) {
            System.out.println(f[i]);
        }
    }
}

class Film {
    private String title;
    private double length;
    public Film() {

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String toString() {
        return "Title: "+title+" Length: "+length;
    }
}
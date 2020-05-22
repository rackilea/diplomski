import java.util.*;
public class Paralells {

    private int id;
    public Paralells(int id) { this.id = id; }
    void run() {
        for (int i = 1; i<=1000; i++) System.out.println(id+" "+i);
    }


    public static void main(String[] args) {

        ArrayList<Paralells> a = new ArrayList();

        a.add(new Paralells(1));
        a.add(new Paralells(2));
        a.add(new Paralells(3));
        a.add(new Paralells(4));
        a.add(new Paralells(5));

        long x = System.currentTimeMillis();
        a.parallelStream().forEach(p -> p.run());
        //a.forEach(p -> p.run()); // sequential
        System.out.println("ELAPSED: " + (System.currentTimeMillis()-x));
    }
}
import java.util.*;

public class Exam {

    Scanner sc;
    Person[] people;

    Exam () {
        sc = new Scanner (System.in);
        people = new Person[5];
    }

    public void getInput () {
        for (int i = 0; i < people.length; i++) {
            System.out.print ("Enter name: ");
            String name = sc.nextLine ();

            System.out.print ("Enter family name: ");
            String fname = sc.nextLine ();

            System.out.print ("Enter id: ");
            int id = sc.nextInt (); sc.nextLine ();

            System.out.println ("Enter points: ");
            float[] points = new float[5];
            for (int j = 0; j < points.length; j++) {
                System.out.printf ("[%d] ", j + 1);
                points[j] = sc.nextFloat (); sc.nextLine ();
            }

            people[i] = new Student (name, fname, id, points);
        }
    }

    public void printInput () {
        for (Person p: people)
            System.out.println (p);
    }

    public void run () {
        getInput ();

        printInput ();
    }

    public static void main (String[] args) {
        new Exam ().run ();
    }

}
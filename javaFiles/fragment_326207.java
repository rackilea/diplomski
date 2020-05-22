import java.util.Scanner;

public class DateChecker111 {

    public static void main (String args[]) {

        Scanner scanner1 = new Scanner(System.in);

        int Manad, Dag;
        System.out.print("Ange Månad>");

        Manad = scanner1.nextInt();
        if (Manad > 0 && Manad < 13) {
        }
        else {
            System.out.print("Felaktig Månad");
        }

        if (Manad == 1 || Manad == 3 || Manad == 5 || Manad == 7 || Manad == 8 || Manad == 10 || Manad == 12) {
            System.out.print("Ange Dag>");
            Dag = scanner1.nextInt();

            // BAD IF
            if (Dag > 0 && Dag < 32);

            System.out.print("Korrekt Datum");
        } else {
            System.out.print("Felaktig Dag i Månaden");
        }

        if (Manad == 2) {
            System.out.print("Ange Dag");
            Dag = scanner1.nextInt();

            // BAD IF
            if (Dag > 0 && Dag < 29);

            System.out.print("Korrekt Datum");
        } else {
            System.out.print("Felaktig Dag i Månaden");
        }

        if (Manad == 4 || Manad == 6 || Manad == 9 || Manad == 11) {
            System.out.println("Ange Dag");
            Dag = scanner1.nextInt();

            // BAD IF
            if (Dag > 0 && Dag < 31);

            System.out.print("Korrekt Datum");
        } else {
            System.out.print("Felaktig Dag i Månaden");

            scanner1.close();

        }
    }
}
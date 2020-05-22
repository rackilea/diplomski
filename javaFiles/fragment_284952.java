package cosine;

public class Main {

    public static double transform(double x) {
        x = Math.abs(x);
        double y = Math.floor(x / (Math.PI * 2));
        return x - y * Math.PI * 2;
    }

    public static double myCos(double x) {

        x = transform(x);

        double alteSumme, neueSumme, summand;
        int j = 0;
        neueSumme = 1.0;
        summand = 1.0;
        do {
            j++;
            summand *= -x * x / j;
            j++;
            summand /= j;
            alteSumme = neueSumme;
            neueSumme += summand;
        } while (neueSumme != alteSumme);
        return alteSumme;
    }

    public static void main(String[] args) {
        int n = 0;
        for (double y = -20 * Math.PI; y < 20 * Math.PI; y += Math.PI / 3) {
            double x = Math.PI / 3 + y;
            double tmpa, tmpb;
            System.out.println(
                    n + ":" + x + ": " + (tmpa = myCos(x)) + " " + (tmpb = Math.cos(x)) + "  DIFF: " + (tmpa - tmpb));
            n++;
        }
    }
}
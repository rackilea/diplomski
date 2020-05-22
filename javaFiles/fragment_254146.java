import java.util.Scanner;

public class Array3 {
    public static void main(String[] arg) {
        Histogram h = new Histogram();
        System.out.println(h.readHistogram());
    } // end main

} // end Array3

class Histogram {
    private String title;
    private double start, stop;
    private double[] data;

    public Histogram(String title, double start, double stop, double[] data,
            int numBars) {
        this.title = title;
        this.start = start;
        this.stop = stop;
        this.data = new double[numBars];

        for (int i = 0; i < numBars; ++i) {
            if (data.length > i) {
                this.data[i] = data[i];
            } // end if
        } // end for

    } // end constructor Histogram

    public Histogram() {
    }

    public String toString() {
        String numOfHash = title + "\n";

        double max = data[0];

        for (int k = 1; k < data.length; ++k) {
            max = Math.max(max, data[k]);
        }

        double scaleFactor = max / 40D;

        double a = start;

        for (int i = 0; i < data.length; ++i) {
            numOfHash += String.format("%.1f", a) + " ";

            int count = (int) Math.round(data[i] / scaleFactor);
            for (int j = 0; j < count; ++j) {
                numOfHash += "#";
            } // end for loop

            numOfHash += " " + String.format("%.2f", data[i]) + "\n";
            a += 0.5D;
        } // end for loop

        return numOfHash;

    } // end toString

    public Histogram readHistogram() {
        int num = 0;
        Scanner stdin = new Scanner(System.in);
        System.out.println("Enter a histogram.");
        System.out.println("Title: ");
        String title = stdin.nextLine();
        System.out.println("Start value: ");
        double start = stdin.nextDouble();
        System.out.println("End Value: ");
        double stop = stdin.nextDouble();
        System.out.println("Data: ");

        double[] data = new double[5];
        for (int i = 0; i < 5; ++i) {
            data[i] = stdin.nextDouble();
            num++;
        }

        stdin.close();

        return new Histogram(title, start, stop, data, num);
    }

} // end Histogram
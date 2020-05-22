import java.util.*;
public class FMLArrays {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String[] movieName = new String[2];
        int[] moviePrice = new int[2];
        int[] moviePrediction = new int[2];
        int[] moviePreformance = new int[2];

        for (int i = 0; i < movieName.length; i++) {

            System.out.print("Enter the name of movie " + (i+1) + ": ");
            movieName[i] = console.nextLine();

            System.out.print("Enter the price of movie " + (i+1) + ": ");
            moviePrice[i] = Integer.parseInt(console.nextLine());

            System.out.print("Enetr the prediction of movie " + (i+1) + ": ");
            moviePrediction[i] = Integer.parseInt(console.nextLine());

            moviePreformance[i] = Math.round(((moviePrediction[i] * 1000000) / moviePrice[i]) * 100) / 100;

            System.out.println();

        }

        for (int i = 0; i < movieName.length; i++) {

            System.out.println();
            System.out.println("Name: " + movieName[i]);
            System.out.println("Price: $" + moviePrice[i]);
            System.out.println("Prediction: $" + moviePrediction[i] + " million");
            System.out.println("Preformance: $" + moviePreformance[i]);

        }

    }

}
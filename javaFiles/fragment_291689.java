import java.io.*;

public class CurrencyConverter {
    public static void main(String[] args) throws IOException {
        String usDollar;
        double usd, euro, pounds, rouble;

        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        System.out.println("\t\t CURRENCY CONVERTER");
        System.out.println("\t\t Please enter the Dollar amount in US DOLLAR");
        usDollar = dataIn.readLine();
        usd      = Double.parseDouble(usDollar);

        rouble = (usd * 34.89);
        pounds = (usd * 0.61);
        euro   = (usd * 0.73);

        System.out.println();
        System.out.println("\t\tYour given amount $" + usd);
        System.out.println("\t\tPounds $" + pounds);
        System.out.println("\t\tRussian Rouble $" + rouble);
        System.out.println("\t\tEuro $" + euro);

    }
}
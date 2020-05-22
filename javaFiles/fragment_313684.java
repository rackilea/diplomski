import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StockAnalysis {

    public static void main(String[] args) {
        StockDataBase startingValue = new StockDataBase();
        StockDataBase endingValue = new StockDataBase();

        try {
            Scanner input = new Scanner(new File("values.txt"));

            int i = 0;

            while (input.hasNext()) {
                startingValue.setStockValue(i, input.nextDouble());
                endingValue.setStockValue(i, input.nextDouble());
                i++;

            }
            input.close();

            for (int z = 0; z < 12; z++) {
                System.out.println("Left : " + startingValue.getStockValue(z) + ", Right : " + endingValue.getStockValue(z));
            }

        } catch (IOException e) {
            System.out.println("Unable to open or read from file.");
        }
    }
}
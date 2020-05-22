import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        Scanner docInName = null;
        PrintWriter docOutName = null;

        do {
            System.out.println("Please enter the filename of the file you would like to read from: ");
            try {
                docInName = new Scanner(new File(user.nextLine()));
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
        } while (docInName == null);

        int lineNum = docInName.nextInt();
        BikePart[] bp = new BikePart[lineNum];
        System.out.println("please enter the max cost for a part: ");
        int cost = user.nextInt();
        user.nextLine();    //SOLUTION HERE

        do {
            System.out.println("please enter a name for the file to write to (end with .txt): ");
            String out = user.nextLine();
            try {
                docOutName = new PrintWriter(out);
                for (int i = 0; i < lineNum; i++) {
                    String line = docInName.nextLine();
                    String[] elements = line.split(",");
                    bp[i] = new BikePart(elements[0], Integer.parseInt(elements[1]), Double.parseDouble(elements[2]),
                            Double.parseDouble(elements[3]), Boolean.parseBoolean(elements[4]));
                    double temp = Double.parseDouble(elements[3]);
                    if ((temp < cost && bp[i].isOnSale() == true)
                            || (bp[i].getListPrice() < cost && bp[i].isOnSale() == false)) {
                        docOutName.write(line);
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } while (docOutName == null);
        user.close();
    }

}
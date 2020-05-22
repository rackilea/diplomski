import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GetProducts {

public static void main(String[] args) {

    ArrayList<Product> products = new ArrayList<Product>();
    String csvFile = "products.csv"; //path to your csv file
    String line = "";
    String headerLine;
    int x = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

          while ((line = br.readLine()) != null) {

              if (x==0) // ignore header line
              {
                  headerLine = line;
              }
              else
              {
                // use comma as separator
                String[] split = line.split(",");

                //Some product names contain commas that are part of the name, so we split again using quotation marks
                if (line.charAt(0) == '"')
                {
                    String[] split2 = line.split("\"");
                    //here we retrieve the rest of the data after the last quotation mark
                    //careful, it will only work if there are quotation marks in the product name only
                    split = split2[split2.length - 1].split(",");
                    products.add(new Product(split2[1], Integer.parseInt(split[1]), Integer.parseInt(split[2])));
                }
                else
                {
                    //Here we just split using commas if there are no quotation marks in the product name
                    products.add(new Product(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2])));
                }
              }
              x++; // increment x;
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    //Output all Product objects
    for (Product product : products)
    {
        System.out.println(product);
    }

    //Output products names only
    for (Product product: products)
    {
        System.out.println(product.getName());
    }
}

}
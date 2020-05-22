import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;


public class Main {

  private static final String FILE_NAME = "file.ser";

  public static void main(String[] args) throws Exception {

    final Vector<Product> products = new Vector<Product>();

    products.add(new Product("1", "1", 1.0, "1"));
    products.add(new Product("2", "2", 2.0, "2"));
    products.add(new Product("3", "3", 3.0, "3"));
    products.add(new Product("4", "4", 4.0, "4"));

    System.out.println("Original products : " + products);

    final ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(new FileOutputStream(FILE_NAME)));

    try {
      out.writeObject(products);
    } finally {
      out.close();
    }

    final ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(new FileInputStream(FILE_NAME)));

    final Vector<Product> productsFromFile = (Vector<Product>) in.readObject();

    System.out.println("Products from file: " + productsFromFile);

  }

}
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

/**
 * Write the numbers in binary.
 */
public class WriteBinary {
  public static void main(String[] argv) throws IOException {
    Vector<int> numbers = getVectorOfNumbers();
    int size = numbers.size();

    String FILENAME = "binary.dat";
    DataOutputStream os = new DataOutputStream(new FileOutputStream(
        FILENAME));
    os.writeInt(size);
    for(int n : numbers) {
      os.writeInt(n);
    }
    os.close();
    System.out.println("Wrote " + size + " numbers to file " + FILENAME);
  }
}
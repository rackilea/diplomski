import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public final class UnicodeBOMInputStreamUsage
{
  public static void main(final String[] args) throws Exception
  {
    FileInputStream fis = new FileInputStream("test/offending_bom.txt");
    UnicodeBOMInputStream ubis = new UnicodeBOMInputStream(fis);

    System.out.println("detected BOM: " + ubis.getBOM());

    System.out.print("Reading the content of the file without skipping the BOM: ");
    InputStreamReader isr = new InputStreamReader(ubis);
    BufferedReader br = new BufferedReader(isr);

    System.out.println(br.readLine());

    br.close();
    isr.close();
    ubis.close();
    fis.close();

    fis = new FileInputStream("test/offending_bom.txt");
    ubis = new UnicodeBOMInputStream(fis);
    isr = new InputStreamReader(ubis);
    br = new BufferedReader(isr);

    ubis.skipBOM();

    System.out.print("Reading the content of the file after skipping the BOM: ");
    System.out.println(br.readLine());

    br.close();
    isr.close();
    ubis.close();
    fis.close();
  }

} // UnicodeBOMInputStreamUsage
import java.io.*;
public class ShowOfficeInstalled {
    public static void main(String argv[]) {
      try {
        Process p = Runtime.getRuntime().exec
          (new String [] { "cmd.exe", "/c", "assoc", ".xls"});
        BufferedReader input =
          new BufferedReader
            (new InputStreamReader(p.getInputStream()));
        String extensionType = input.readLine();
        input.close();
        // extract type
        if (extensionType == null) {
          System.out.println("no office installed ?");
          System.exit(1);
        }
        String fileType[] = extensionType.split("=");

        p = Runtime.getRuntime().exec
          (new String [] { "cmd.exe", "/c", "ftype", fileType[1]});
        input =
          new BufferedReader
            (new InputStreamReader(p.getInputStream()));
        String fileAssociation = input.readLine();
        // extract path
        String officePath = fileAssociation.split("=")[1];
        System.out.println(officePath);
      }
      catch (Exception err) {
        err.printStackTrace();
      }
    }
  }
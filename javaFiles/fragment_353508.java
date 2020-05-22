import java.io.*;

import java.util.Arrays;

public class CSVRead{

public static void main(String[] arg) throws Exception {
    Map<String, String> emailPasswordMap = new HashMap<String, String> ();
    BufferedReader CSVFile =
        new BufferedReader(new FileReader("testa453.csv"));
    String dataRow = CSVFile.readLine();
    while (dataRow != null){
        String[] dataArray = dataRow.split(",");
        emailPasswordMap.put (dataArray[0], dataArray[1]);
        dataRow = CSVFile.readLine();
    }
    CSVFile.close();

    String email = "xxx";
    String password = "yyy";

    if (password.equals (emailPasswordMap.get (email)) {
        System.out.println ("Email/password combination is valid");
    }
    else {
        System.out.println ("Email/password combination is invalid");
    }
}
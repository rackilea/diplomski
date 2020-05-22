import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Main {
   public static void main(String[] args) throws Exception {
      String html = "";


      URL url = new URL("https://dl.dropboxusercontent.com/u/16258361/urnik/data.js");
      URLConnection connection = url.openConnection();
      BufferedReader in = new BufferedReader(new InputStreamReader(
           connection.getInputStream()));
      String inputLine;
      while ((inputLine = in.readLine()) != null)
         html += inputLine;
      in.close();


      String array[] = html.split("podatki");
      ArrayList<String> dataArray = new ArrayList<String>();
      for (int i = 2; i < array.length; i++)
         dataArray.add(array[i]);

      String last = dataArray.get(dataArray.size()-1);
      String lastCleared = "";
      for (int i = 0; i < last.length(); i++) {
         if (!last.substring(i, i+1).contains("r")) lastCleared += last.substring(i, i+1);
         else break;
      }
      dataArray.set(dataArray.size() - 1, lastCleared);

      for (int i = 0; i < dataArray.size(); i++) {
         String string = dataArray.get(i);
         if (string.contains("new Array")) {
            dataArray.remove(i);
            i--;
         }
         else {
            string = string.replaceAll("]\\[", ";");
            string = string.replaceAll("\\[", "");
            string = string.replaceAll("]", "");
            string = string.replaceAll("\"", "");
            string = string.replace(" = ", ";");
            dataArray.set(i, string);
        }
      }

      int lastIndex1;
      String string = "";
      String lastString = dataArray.get(dataArray.size() - 1);
      for (int i = 0; i < lastString.length(); i++) {
         if (lastString.substring(i, i+1).contains(";"))
            break;
         string += lastString.substring(i, i+1);
      }

      lastIndex1 = Integer.parseInt(string);
      boolean start = false;
      for (int i = 0; i < lastString.length(); i++) {
         if (start) {
            string = lastString.substring(i, i + 1);
            break;
      }
      if (lastString.substring(i, i+1).contains(";"))
           start = true;
      }
      int lastIndex2 = Integer.parseInt(string);

      String finalData[][] = new String[lastIndex1+1][lastIndex2+1];
      for (int i = 0; i < dataArray.size(); i++) {
         String components[] = dataArray.get(i).split(";");
         if (components.length == 3)
            finalData[Integer.parseInt(components[0])][Integer.parseInt(components[1])] = components[2];
         else
           finalData[Integer.parseInt(components[0])][Integer.parseInt(components[1])] = "";           
      }

      for (int i = 0; i < finalData.length; i++) {
         for (int j = 0; j < finalData[i].length; j++)
            System.out.println(finalData[i][j]);
         System.out.println("\n");
      }
   }
}
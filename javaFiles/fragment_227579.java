import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Runobject implements Runnable {
    public String address;

    public static void main(String a[]) {
        System.out.println("Start");
        readFriendData(new String[] { "http://google.com", "http://yahoo.com" });
        System.out.println("End");
    }

    public static void readFriendData(String[] urls) {
        Thread[] urlThreads = new Thread[urls.length];
        for (int x = 0; x < urls.length; x++) {
            Runobject input = new Runobject(urls[x]);
            Thread one = new Thread(input);
            urlThreads[x] = one;

        }

        for (int x = 0; x < urls.length; x++) {
            urlThreads[x].start();
        }
    }

    public Runobject(String theAdress) {
        address = theAdress;
        System.out.println(address);
    }

    @Override
    public void run() {
        try {
            URL url = new URL(address);
            URLConnection urlConnection = url.openConnection();

            BufferedReader scanner = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));

            int countOfLines = 0;
            String input = scanner.readLine();
            while (input != null && !input.equals("</body>")) {
                countOfLines++;
                if (input.startsWith("<tr> <td>addperson</td>")) {
                    input.replaceAll("<tr> <td>addperson</td>", "");
                    input.replaceAll(" <td>", "");
                    input.replaceAll("</td> </tr>", "");

                    // net.addUser(input);
                } else if (input.startsWith("<tr> <td>addfriend</td>")) {
                    String[] bits = new String[2];
                    input.replaceAll("<tr> <td>addfriend</td>", "");
                    bits = input.split("</td> <td>");
                    input.replaceAll(" <td>", "");
                    input.replaceAll("</td> </tr>", "");

                    // net.friend(bits[0], bits[1]);
                    // net.friend(bits[1], bits[0]);

                }

                input = scanner.readLine();

            }
            scanner.close();
            System.out.println(address + " has " + countOfLines + " lines");
        } catch (IOException e) {
            System.out.println("bad URL");
        }
    }    
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadList {

    public static void main(String[] args) throws IOException {

        BufferedReader in = null;
        FileReader fr = null;
        List<Double> list = new ArrayList<Double>();

        try {
            fr = new FileReader("list.txt");
            in = new BufferedReader(fr);
            String str;
            while ((str = in.readLine()) != null) {
                list.add(Double.parseDouble(str));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
            fr.close();
        }

        for (double d : list) System.out.println(d);
    }

}
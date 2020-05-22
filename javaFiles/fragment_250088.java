import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestAdj {

    HashMap<String, ArrayList<String>> map;


    public TestAdj() {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("input.txt"));
            map = new HashMap<String, ArrayList<String>>();
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] set = line.split("\t");
                if (map.containsKey(set[0])) {
                    map.get(set[0]).add(set[1]);
                } else {
                    ArrayList lst = new ArrayList<String>();
                    lst.add(set[1]);
                    map.put(set[0], lst);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TestAdj.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(TestAdj.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void displayAdj() {
        Object[] sources=map.keySet().toArray();

        for (int i = 0; i < sources.length; i++) {
            System.out.print(sources[i]+" -->");
            System.out.println(map.get(sources[i]));
        }
    }

    public static void main(String[] args) {
        new TestAdj().displayAdj();
    }
}
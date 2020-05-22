import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Merge {

    static class Student {
        String ID,Name,LastName,WorkPlace,Proj1,Proj2,Proj3,Assignment,Final;

        @Override
        public String toString() {
            return ID + "," + Name + "," + ((Integer.parseInt(Proj1) + Integer.parseInt(Proj2) + Integer.parseInt(Proj3))/3) + "," + Assignment + "," + Final + "," + WorkPlace;
        }
    }

    public static void main(String[] args) throws IOException {

        // PrintWriter object for info3.txt
        PrintWriter pw = new PrintWriter("info3.txt");

        // BufferedReader object for info1.txt & info2.txt
        BufferedReader br1 = new BufferedReader(new FileReader("info1.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("info2.txt"));

        // skip header lines
        br1.readLine();
        br2.readLine();

        Map<String, Student> map = new HashMap<>();

        String line;
        while((line = br1.readLine()) != null) {
            String[] data = line.split(",");
            Student s = new Student();
            s.ID = data[0];
            s.Name = data[1];
            s.LastName = data[2];
            s.WorkPlace = data[3];
            map.put(s.ID, s);
        }


        while((line = br2.readLine()) != null) {
            String[] data = line.split(",");
            Student s = map.get(data[0]);
            s.Proj1 = data[1];
            s.Proj2 = data[2];
            s.Proj3 = data[3];
            s.Assignment = data[4];
            s.Final = data[5];
        }

        pw.println("ID,Name,P_Average,Assignment,Final,WorkPlace");

        map.values().forEach( pw::println );

        pw.flush();
        br1.close();
        br2.close();
        pw.close();
    }
}
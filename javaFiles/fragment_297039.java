import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Merge {

    public static void main(String[] args) throws IOException {

        List<String> students = Files.readAllLines(Paths.get("info1.txt"));
        List<String> grades = Files.readAllLines(Paths.get("info2.txt"));

        List<String> results = new ArrayList<>();

        results.add("ID,Name,P_Average,Assignment,Final,WorkPlace");

        // remove header lines
        students.remove(0);
        grades.remove(0);

        for(String student : students) {
            String[] s = student.split(",");
            for(String grade : grades) {
                String[] g = grade.split(",");
                if(Objects.equals(s[0], g[0])) {
                    results.add(s[0] + "," + s[1] + "," + ((Integer.parseInt(g[1]) + Integer.parseInt(g[2]) + Integer.parseInt(g[3]))/3) + "," + g[4] + "," + g[5] + "," + s[3]);
                }
            }
        }

        Files.write(Paths.get("info3.txt"), results);

    }
}
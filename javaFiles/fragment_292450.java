import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class PrintUnique {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> lines = new HashSet<String>();
        String line;
        while((line = br.readLine()) != null) {
            if(lines.add(line))
                System.out.println(line);
        }
    }
}
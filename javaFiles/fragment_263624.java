import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class AppendIfFromFileScanner {
    public static void main(String args[]) {
        File file = new File("C:\\Users\\frencke\\workspace\\Testing Stuff\\Append Tetsing\\file3.txt");
        ArrayList<String> lines = new ArrayList<String>();
        String delimiter = ".*\\s+&.*";
    try {
        FileWriter fstream = new FileWriter("file4.txt");
        BufferedWriter out = new BufferedWriter(fstream);
    try {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());}
for(int i=0; i<lines.size(); i++){
    for(String s=null; i<lines.size(); i++){
        s = lines.get(i);
        if(!s.matches(delimiter))
        out.write("\r\n" + s);
        else if(s.matches(delimiter))
        out.write(s);}
}
    }catch (FileNotFoundException e) {
System.out.println("Cannot find file.");
}out.close();
}catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
    }
}
}
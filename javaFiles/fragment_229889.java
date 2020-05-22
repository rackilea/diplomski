import java.io.*;
import java.util.Scanner;

File file = new File("somefilepath");
Scanner s = new Scanner(file);
String name = null;
while (s.hasNextLine()) {
    String line = s.nextLine();
    if (line.startsWith("Name"))
        name = line.substring(5);
}
// The variable "name" will be the name you seek (or be null if line not found)
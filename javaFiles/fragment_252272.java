import java.io.FileWriter;
import java.io.IOException;

try
{
FileWriter fout = new FileWriter("output.txt"); // ("output.txt", true) for appending
fout.write(msg); // Assuming msg is already defined
fout.close();
}
catch (IOException e)
{
e.printStackTrace();
}
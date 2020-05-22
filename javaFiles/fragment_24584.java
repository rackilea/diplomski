import java.sql.SQLException;
import java.util.Scanner;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Citation2{

    String title;
    String author;
    String year;
    String conference;
    String index;
    String cite;
    String abstracts;
    String Line;

    public static void main (String[] args) throws SQLException,
    ClassNotFoundException, IOException{

        Citation2 parser = new Citation2("test.txt");
        parser.processLineByLine();

    }

    public Citation2(String aFileName){
        fFilePath = Paths.get(aFileName);
    }

    public final void processLineByLine() throws IOException, ClassNotFoundException, SQLException {
        try (Scanner scanner =  new Scanner(fFilePath, ENCODING.name())){
            String nextLine = null;
            if(scanner.hasNextLine()){
                nextLine = scanner.nextLine();
            }
            while (nextLine!=null){
                nextLine = processLine(nextLine, scanner);
            }      
        }
    }

    protected String processLine(String aLine, Scanner scanner) throws ClassNotFoundException, SQLException {
        String nextLine = null;

        if (aLine.startsWith("#*")) {
            title = aLine.substring(2);
            Line = title;
        } 
        else if (aLine.startsWith("#@")){
            author = aLine.substring(2);
            Line = Line + "\t" + author;
        }
        else if (aLine.startsWith("#t")){
            year = aLine.substring(2);
            Line = Line + "\t" + year;

        }
        else if (aLine.startsWith("#c")){
            conference = aLine.substring(2);
            Line = Line + "\t" + conference;
        }
        else if (aLine.startsWith("#index")){
            index = aLine.substring(6);
            Line = Line + "\t" + index;
        }
        else if (aLine.startsWith("#%")){
            cite = aLine.substring(2);
            while(scanner.hasNextLine() && (nextLine = scanner.nextLine()).startsWith("#%"))
            {
                cite += "," + nextLine.substring(2); 
            }   
            Line = Line + "\t" + cite;
            System.out.println(Line);
        } 
        if(nextLine== null && scanner.hasNextLine()){
            nextLine = scanner.nextLine();
        }
        return nextLine;
    }

    private final Path fFilePath;
    private final static Charset ENCODING = StandardCharsets.UTF_8;  

}
import java.util.*; 

public class TESTTEST
{
public static void main(String[] args) { 
    Scanner sc = new Scanner(System.in); 
    System.out.print("Enter file path:"); 

    //This is the path to the file you want to read from
    String path = sc.nextLine();
    System.out.print(" Enter character to count:"); 

    char ch = sc.next().toUpperCase().charAt(0);

    //read all lines into a list
    List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
    int count = 0; 
    for(String linestr:lines){
        for(char ch0:linestr.toCharArray()) { 
            if(ch0 == ch) 
                count++; 
        }
    }
    System.out.println(" The character " + "'"+ch+"'" + " appears in the file wc4 " + count +  " times."); 
    }
}
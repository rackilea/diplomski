public class PracticeFiles {

public static void main(String[] args) throws Exception{
int charCount=0;
int wordCount=0;
int lineCount=0;
String count;
StringTokenizer st;
BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter file: ");
    String fileName = buf.readLine();
    File file = new File(fileName);
    buf=new BufferedReader(new FileReader(file));
    while((count=buf.readLine())!=null)
        {
            lineCount++;
            st=new StringTokenizer(count," ,;:.");
            while(st.hasMoreTokens())
                {
                    wordCount++;
                    count=st.nextToken();
                    charCount+=count.length();
                }
        }
        System.out.println("The file name is: " + file.getName());
        System.out.println("Character Count : " + charCount);
        System.out.println("Word Count : " + wordCount);
        System.out.println("Line Count : " + lineCount);
        buf.close();
    }
}
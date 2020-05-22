import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MyString 
{
    public static Set<MyString> globalSet; 
    private String line;
    public String getLine(){
        return this.line;
    }

    public void  setLine(String newLine){
        this.line = newLine;  
    }



    public static void main(String[] args) {
        File folder = new File("C:\\Users\\hbm5cf7\\Documents\\NewF");
        globalSet = new HashSet<MyString>(); 
        File[] listOfFiles = folder.listFiles();

        for(File file : listOfFiles) {
            dosomething(file);
        }

        for(MyString t : globalSet)
        {
            System.out.println(t.getLine());
        }

    }
    public static void dosomething(File file)
    {

        try {

            BufferedReader in = new BufferedReader(new FileReader(file));
            MyString str;
            String line;
            while ((line = in.readLine()) != null) {
                str = new MyString();
                str.setLine(line);
                globalSet.add(str);
            }
            in.close();



        }catch(IOException e)
        {
            System.out.println(e);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((line == null) ? 0 : line.split(";", 2)[1].hashCode());
        return result;
    }

     @Override
        public boolean equals(Object obj)
        { 

            if (this == obj)
            {
                return true;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            if (this.line.equals(((MyString) obj).getLine())) 
            {
                return true;
            }
            String splitString = ((MyString) obj).getLine().split(";", 2)[1];   
            if(this.line.endsWith(splitString))
            {
                return true;  
            }
            return false; 
         }

}
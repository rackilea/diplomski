import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        String name = null;
        String age = null;
        String month = null;
        List<Person> people = new ArrayList<Person>();

        try
        {
            String fileName = "people.txt";
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;

            while ((line = bufferedReader.readLine()) != null)
            {
                String[] information = line.split(" ");

                if (Arrays.asList(information).contains("Name:"))
                {
                    name = information[1];
                }
                if (Arrays.asList(information).contains("Age:"))
                {
                    age = information[1];
                }
                if (Arrays.asList(information).contains("month:"))
                {
                    month = information[2];
                }
                if (line.equals("END OF LIST"))
                {
                    people.add(new Person(name, age, month));

                    name = "";
                    age = "";
                    month = "";
                }
            }

            for (Person person : people)
            {
                System.out.println(person);
                System.out.print("\n");
            }
        }
        catch (FileNotFoundException e) 
        {
            System.out.println(e.getMessage());
        } 
        catch (IOException ex) 
        {
            System.out.println("Error reading people.txt");
        }
        finally
        {
            if (bufferedReader != null)
            {
                try
                {
                    bufferedReader.close();
                }
                catch (IOException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            if (fileReader != null)
            {
                try
                {
                    fileReader.close();
                }
                catch (IOException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
        }       
    }
}
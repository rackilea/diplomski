import java.util.*;
import java.text.*;
import java.time.*;
import java.io.*;

public class Database{
    public List<Student> studentList;
    private long lastModified;
    @SuppressWarnings("unchecked")

    public Object loadDb()
    {//Loads the database from file.
        File data = new File("database.db");
        if(lastModified == data.lastModified())
        {
            return studentList;//Returning main memory;
        }
        Scanner sc;
        try
        {
            sc = new Scanner(data).useDelimiter("\n");//To get individual lines.
            String line;
            if(studentList!=null)
            {//Clearing main memory.
                studentList.clear();
            }
            else
            {//Creating new main memory.
                studentList = new ArrayList<Student>();
            }

            while(sc.hasNext())
            {
                line = sc.next();
                Scanner l = new Scanner(line).useDelimiter("\\|");//To get info
                String name, PID, major, minor, cgpaSt, college, email;
                name = l.next().split(":")[1];
                PID = l.next().split(":")[1];
                major = l.next().split(":")[1];
                minor = l.next().split(":")[1];
                cgpaSt = l.next().split(":")[1];
                college = l.next().split(":")[1];
                email = l.next().split(":")[1];
                double CGPA = Double.valueOf(cgpaSt);
                Student stud = new Student(name,PID, major, minor, CGPA, college, email);//Creating new student with same info.
                studentList.add(stud);//Adding the student to memory.
            }
            sc.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }   
        return studentList;
    }
    @SuppressWarnings("unchecked")
    public void updateDb(Object studList)
    {//Updates the database.
        File data = new File("database.db");
        PrintWriter fs;
        try
        {
            fs = new PrintWriter(data);
        }
        catch(IOException e)
        {
            System.out.println("IO Exception!");
            return;
        }
        fs.flush();
        ArrayList<Student>studs = (ArrayList<Student>)studList;
        for(int i = 0;i<studs.size();i++)
        {
            fs.print(studs.get(i).toString());
            if(i != studs.size() -1)
            {
                fs.print("\n");
            }
        }
        fs.close();
        lastModified = data.lastModified();
        loadDb();//Loading updated database.
    }


}
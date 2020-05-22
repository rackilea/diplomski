import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Student implements Serializable
{
    int id;
    String name;

    public Student(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "[id: " + id + " , name: " + name+ "]";
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        //set those values to their default, which you don't want to retrieve
        this.id = 0;
    }
}
import java.io.*;
class Person implements Serializable //Make Person class Serializable so that its objects can be serialized.
{
    private static final long SerialVersionUID = 20L;
    String name;
    int age;
    public Person(String name,int age)
    {
        this.name = name;
        this.age = age;
    }
    public String toString()
    {
        return "Name:"+name+", Age:"+age;
    }
}
public class SerializeArray 
{
    public static void saveArray(Person[] arr)throws Exception //writes the array of Person to a file "Persons.ser"
    {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Persons.ser"));
        os.writeObject(arr);
        os.close();
    }
    public static Person[] loadArray()throws Exception //Reads the array of Persons back from file.
    {
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("Persons.ser"));
        Person[] arr = (Person[]) oin.readObject();
        oin.close();
        return arr;
    }
    public static void main(String[] args) throws Exception
    {
        Person[] arr= new Person[3];
        for (int i = 0 ; i < arr.length ; i++)
        {
            arr[i] = new Person("Person"+i,25+i);
        }
        System.out.println("Saving array to file");
        saveArray(arr);
        System.out.println("Reading array back from file");
        Person[] per = loadArray();
        for (Person p : per)
        {
            System.out.println(p);
        }
    }
}
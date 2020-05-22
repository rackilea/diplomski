import com.thoughtworks.xstream.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;



public class RegistrosArrayList02_xml {

    public static void main(String[] args) 
    {
       doOneRecordInFile();
       doMultipleRecordsInFile();
    }

    static void doMultipleRecordsInFile()
    {
       XStream xstream = new XStream();
       xstream.alias("registrosarraylist02xml.Pessoas", Person.class);
       xstream.alias("list", People.class);
       xstream.aliasField("nome",Person.class,"name");
       xstream.aliasField("idade",Person.class,"age");
       People people = createPeople();
       String xml = xstream.toXML(people);
       RecordRead.record(xml,"test2.xml");
       People people2 =  (People) xstream.fromXML( RecordRead.read("test2.xml") );
       show( people2.getEntries() );
    }

    static void doOneRecordInFile()
    {
       XStream xstream = new XStream();
       xstream.alias("registrosarraylist02xml.Pessoas", Person.class);
       xstream.aliasField("nome",Person.class,"name");
       xstream.aliasField("idade",Person.class,"age");
       Person myObject = new Person(10,"John",45);
       String xml = xstream.toXML(myObject);
       // write Person class to file as XML
       RecordRead.record(xml,"teste.xml");
       // read Person class from XML file
       Person p = (Person) xstream.fromXML( RecordRead.read("teste.xml") );
       System.out.println("----------- one record -------------");
       System.out.println(p);
       System.out.println(p.ID + "  - " + p.name + " - " + p.age);
       System.out.println( (Person) xstream.fromXML(RecordRead.read("teste.xml")));
    }


    static void show(ArrayList<Person> mylist) 
    {
        System.out.println("---------- multiple records -------------");
        System.out.println("ID - name - age");     
        for (int i = 0; i < mylist.size(); i++) 
        {
            Person p = mylist.get(i);
            System.out.println(p.ID + "  - " + p.name + " - " + p.age);
            // OR:
        // System.out.println(p);
        }
    }

    static People createPeople()
    {
        People people = new People();
        Person a = new Person(1,"Regis",25);
            Person b = new Person(2,"Rose",32);
        Person c = new Person(3,"david",10);
        people.add(a);
        people.add(b);
        people.add(c);
        return people;
    }

}

class People {

    private ArrayList<Person> entries = new ArrayList<Person>();
    public void add(Person p)
    {
        entries.add(p);
    }
    ArrayList<Person> getEntries() { return entries; }

}

class Person {

    public static int lastID = 0;
    public int ID;
    public String name;
    public int age;

    public Person() {
        ID = Person.lastID++;
    }
    public Person(String id, String Name,String Age) {
        ID = Integer.parseInt(id);
        name = Name;
        age = Integer.parseInt(Age);
    }

    public Person(int id, String Name,int Age) {
        ID = id;
        name = Name;
        age = Age;
    }

    public String toString()
    {
       return ID + "  - " + name + " - " + age;
    }
}


class RecordRead {

    static void record(String xml,String filename) {
        try {
            FileWriter w = new FileWriter(filename);
            w.write(xml);
            w.flush();
            w.close();
        } catch (Exception e) {
            System.out.println("Error record() XML: " + e);
        }
    }

    static String read(String filename) {
        try {
            Scanner in = new Scanner(new File(filename));
            StringBuilder sb = new StringBuilder();
            while (in.hasNext()) {
                sb.append(in.next());
            }
            in.close();
            return sb.toString();
        } catch (Exception e) {
            System.out.println("Error read XML: " + e);
        }
        return "";
    }
}
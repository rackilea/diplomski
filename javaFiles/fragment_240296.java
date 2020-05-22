public class Person implements Serializable {
    private static final long serialVersionUID = -3206878715983958638L;
    String name;
    String mobile_number;
    String city;


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p = new Person();
        p.name = "foo";
        // Write
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.dat"))){
            oos.writeObject(p);
        }
        // Read
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.dat"))) {
            Person person = (Person) ois.readObject();
            System.out.println(person.name);
        }
    }
}
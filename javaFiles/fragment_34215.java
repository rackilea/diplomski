public class HashMapSample {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<Person, String>();
        map.put(new Person(100, "name 100"),  "this is person 100");
        map.put(new Person(200, "name 200"),  "this is person 200");

        Person key = new Person(100, "new name 100");
        if (map.containsKey(key)) {
            System.out.println(map.get(key));
        } else {
            System.out.println("NOT FOUND");
        }
    }
}

class Person {
    int id;
    String name;

    public Person (int id, String name) {
        this.id = id;
        this.name =  name;
    }

    @Override
    public int hashCode() {
        return id;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            return person.id == this.id;
        }
        return false;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
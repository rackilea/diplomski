class Ideone
{
    public class Person {
        public String Name;
        public String Address;

        public Person(String Name, String Address) {
            this.Name = Name;
            this.Address = Address;
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Person person = new Person("John", "London");

        // System.out.println(person.Name);
        Gson gson = new Gson();
        String jsonPerson = gson.toJson(person);
    }
}
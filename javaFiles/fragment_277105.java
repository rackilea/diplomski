public class ComplexJacksonObject extends BaseJsonObject {
    public int Start;
    public int Count;
    public Person MyPerson;
    public List<String> Strings;

    public class Person extends BaseJsonObject {
        public String Firstname;
        public String Lastname;
        public Address Where;
    }

    public class Address extends BaseJsonObject {
        public String Street;
        public int Number;
    }
}
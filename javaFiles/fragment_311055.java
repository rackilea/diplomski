public class Polymorphism3Main {

    public static void main(String []args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(generatePerson());
        System.out.println("json = " + json);
        System.out.println(objectMapper.readValue(json, Request.class));

        json = objectMapper.writeValueAsString(generateAddress());
        System.out.println("json = " + json);
        System.out.println(objectMapper.readValue(json, Request.class));
    }

    private static Person generatePerson() {
        Person result = new Person();
        result.setName("name");
        result.setSurname("surname");
        return result;
    }

    private static Address generateAddress() {
        Address address = new Address();
        address.setAddress1("address 1");
        address.setCity("city");
        address.setZip("324212");
        return address;
    }
}

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Person.class, name = "person"),
        @JsonSubTypes.Type(value = Address.class, name = "address")
})
interface Request {
}

class Person implements Request {
    private String name;
    private String surname;
}

class Address implements Request {
    private String address1;
    private String city;
    private String zip;
}
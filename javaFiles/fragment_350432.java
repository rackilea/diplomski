public class JacksonValue {
    final static String JSON = "{\n"
            +"   \"code\":\"C001\",\n"
            +"   \"city\": \"Pune\",\n"
            +"   \"street\": \"ABC Road\"\n"
            +"}";

    static class Address {
        public String city;
        public String street;

        @Override
        public String toString() {
            return "Address{" +
                    "city='" + city + '\'' +
                    ", street='" + street + '\'' +
                    '}';
        }
    }

    static class Customer {
        public String code;
        @JsonUnwrapped
        public Address address;

        @Override
        public String toString() {
            return "Customer{" +
                    "code='" + code + '\'' +
                    ", address=" + address +
                    '}';
        }
    }


    public static void main(String[] args) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.readValue(JSON, Customer.class));
    }
}
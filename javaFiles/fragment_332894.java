public  class Demo {
        public static void main(String[] args) throws IOException {
            String s = "{" +
                    "  \"code1\" : {" +
                    "    \"price\" : 100," +
                    "    \"type\" : null" +
                    "  }," +
                    "  \"code3\" : {" +
                    "    \"somethingElsse\" : false," +
                    "    \"otherType\" : 1" +
                    "  }," +
                    "  \"code2\" : {" +
                    "    \"price\" : 110," +
                    "    \"type\" : null" +
                    "  }" +
                    "}";


            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Map<String, Person> mapPerson = mapper.readValue(s, MapPerson.class);

            Map<String, Person> filteredMap = Maps.filterValues(mapPerson, new Predicate<Person>() {
                @Override
                public boolean apply(Person person) {
                    return person.isNotEmpty();
                }
            });

            System.out.println(filteredMap);


        }

        public static class MapPerson extends HashMap<String, Person> {}

        public static class Person{

            private int price;
            private String type;

            public Person() {
            }

            public boolean isNotEmpty() {
                return !(0 == price && null ==type);
            }

            @Override
            public String toString() {
                return "Person{" +
                        "price=" + price +
                        ", type='" + type + '\'' +
                        '}';
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
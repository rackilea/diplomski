public class Test {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "Jack";
        person1.age = 18;
        person1.favoriteSuperhero = "Superman";

        Person person2 = new Person();
        person2.name = "Jack";
        person2.age = 20;
        person2.favoriteSuperhero = "Superman";

        Map<String, List<Object>> uncommonTraits = getUncommonTraits(person1, person2);
        for(Entry<String, List<Object>> entry : uncommonTraits.entrySet()){
            System.out.println(entry.getKey() + ":\t" + entry.getValue());
        }
    }

    private static Map<String, List<Object>> getUncommonTraits(Person p1, Person p2) {
        Map<String, List<Object>> result = new HashMap<>();
        for(Field field : Person.class.getDeclaredFields()){
            try {
                if(!(field.get(p1).equals(field.get(p2)))){
                    result.put(field.getName(), new ArrayList<Object>(Arrays.asList(field.get(p1), field.get(p2))));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}

class Person {
    public String name;
    public int age;
    public String favoriteSuperhero;
}
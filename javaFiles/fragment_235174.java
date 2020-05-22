public class Main
{

    public static class Person
    {
        String name;
        Integer age;

        public Person(String name, Integer age)
        {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString()
        {
            return "Person with name=" + name + " and age=" + age;
        }
    }

    public static void main(String[] args) throws Exception
    {
        LinkedHashMap<String, Person> map = new LinkedHashMap<String, Person>();

        // fill the map
        map.put("a", new Person("Stefan", 45));
        map.put("b", new Person("Lisa", 40));
        map.put("c", new Person("Madonna", 60));

        // print the map
        System.out.println(map);

        // or iterate over the content
        for (Map.Entry<String, Person> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + "-->" + entry.getValue().toString());
        }
    }

}
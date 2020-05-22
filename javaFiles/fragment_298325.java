public class Grouping {

    public class Person {
        String group;
        String subgroup;

        Person(String group, String subgroup){
            this.group = group;
            this.subgroup=subgroup;
        }
    }

    @Test
    public void test() {
        List<Person> list = new ArrayList<>();

        list.add(new Person("Tins", "G13AA"));
        list.add(new Person("Tins", "G13AD"));
        list.add(new Person("Cans", "G13DA"));
        list.add(new Person("Cans", "G13DB"));
        list.add(new Person("Cans", "G13DD"));

        Map<String, List<String>> result = list.stream()
              .collect(Collectors.groupingBy(p->p.group, Collectors.mapping(p->p.subgroup, Collectors.toList())));

        System.out.println(result);
    }

}
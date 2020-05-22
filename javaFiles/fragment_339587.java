public class DemoDemo {
    public static void main(String[] args) {
        Demo object1 = new Demo(100,"saran");
        Demo object2 = new Demo(20 ,"nivas");

        List<Demo> list=new ArrayList<>();
        list.add(object1);
        list.add(object2);

        list
          .stream()
             .filter(d1 -> d1.name.equalsIgnoreCase("saran"))
                .forEach(d2 -> System.out.println(d2.name + " of age " + d2.age));
    }
}

class Demo {
    public final int age;
    public final String name;

    public Demo (int age, String name) {
        this.age = age;
        this.name = name;
    }
}
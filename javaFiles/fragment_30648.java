public class NotArrayList {

    public static void main(String[] args) {
        Dog[] dogs = new Dog[3];

        Dog d1 = new Dog();
        d1.setName("aaa");
        d1.setAge(1);

        Dog d2 = new Dog();
        d2.setName("bbb");
        d2.setAge(1);

        Dog d3 = new Dog();
        d3.setName("ccc");
        d3.setAge(1);

        dogs[0] = d1;
        dogs[1] = d2;
        dogs[2] = d3;

        Dog[] res = Dog.removeByName(dogs, "aaa");
        for (Dog d : res) {
            if (d != null)
                System.out.println(d.getName());
        }
    }
}
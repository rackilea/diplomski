// Main Class To Test
class TestDog {
    public static void main(String[] args) {

        Animal a = new Animal();
        Dog b = new Dog();
        Animal c = new Dog();

        a = b;
        System.out.println(a.getType());
        System.out.println(b.getType());
        System.out.println(c.getType());
    }

}
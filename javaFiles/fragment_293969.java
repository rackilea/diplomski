public class monkey {
    public static void main(String[] args) {
        Fruit jeff = new Fruit("ree");
        Fruit mike = new Apple("ree");

        jeff.talk();
        mike.talk();
    }

    static class  Fruit {
        String sound;

        public Fruit(String s) {
            sound = s;
        }

        public void talk() {
            System.out.print(sound);
        }
    }

    static class Apple extends Fruit {
        public Apple(String s) {
            super(s);
        }
    }
}
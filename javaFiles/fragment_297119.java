public class Animal {
}

public abstract class Dog extends Animal {

    public abstract String getName();

    public static class Husky extends Dog {
        @Override
        public String getName() {
            return "husky";
        }
    }

    public static class Lab extends Dog {
        @Override
        public String getName() {
            return "labrador";
        }
    }

}
public class AnimalDecorator {

    static abstract class Animal {
        public abstract String makeNoise();
    }   
    static class Dog extends Animal {
        @Override public String makeNoise() { return "woof"; }
    }
    static class Cat extends Animal {
        @Override public String makeNoise() { return "meow"; }
    }

    static class Normal extends Animal {
        protected final Animal delegate;
        Normal(Animal delegate)     { this.delegate = delegate; }
        @Override public String makeNoise() {
            return delegate.makeNoise();
        }
    }
    static class Loud extends Normal {
        Loud(Animal delegate)       { super(delegate); }
        @Override public String makeNoise() {
            return String.format("%S!!!", delegate.makeNoise());
        }       
    }
    static class Stuttering extends Normal {
        Stuttering(Animal delegate) { super(delegate); }
        @Override public String makeNoise() {
            return delegate.makeNoise().replaceFirst(".", "$0-$0-$0-$0");
        }
    }

    public static void keepPokingIt(Animal a) {
        // let's skip the details for now...
        System.out.println(a.makeNoise());
    }
    public static void main(String[] args) {
        keepPokingIt(new Cat());
        // meow

        keepPokingIt(new Stuttering(new Dog()));
        // w-w-w-woof

        keepPokingIt(new Loud(new Cat()));
        // MEOW!!!

        keepPokingIt(new Loud(new Stuttering(new Dog())));
        // W-W-W-WOOF!!!        
    }
}
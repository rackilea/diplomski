public class FruitPlant extends Plant {
    public static enum Type {
        PEACH_TREE("peach", 3, 80),
        // ...

        public Fruit.Type getFruit() {
            switch(this) {
                case PEACH_TREE: return Fruit.Type.PEACH;
                // ...
                default: throw new IllegalStateException();
            }
        }

        // ...
    }
    // ...
}
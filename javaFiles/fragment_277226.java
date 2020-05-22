enum Foo {
    SQUARE {
        public String getColor() {
            return "RED";
        }
    },
    CIRCLE {
        public String getColor() {
            return "GREEN";
        }
    },
    TRIANGLE {
        public String getColor() {
            return "BLUE";
        }
    };
    public abstract String getColor();

    public void fun() {
        System.out.println("I am a " + name() + " and my color is " + getColor());
    }
}
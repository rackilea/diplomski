class Foo {

    protected enum Action {
        FUNCTION_0 {
            public void act(Foo foo) { ... }
        },

        FUNCTION_1 {
            public void act(Foo foo) { ... }
        },

        FUNCTION_2 {
            public void act(Foo foo) { ... }
        },

        FUNCTION_3 {
            public void act(Foo foo) { ... }
        },

        ;

        public abstract void act(Foo foo);
    }

    protected static final Action[] ACTIONS = new Action[154];
    static {
        Arrays.fill(ACTIONS, 0, 143, Action.FUNCTION_0);
        Arrays.fill(ACTIONS, 143, 144, Action.FUNCTION_1);
        Arrays.fill(ACTIONS, 144, 153, Action.FUNCTION_2);
        Arrays.fill(ACTIONS, 153, 154, Action.FUNCTION_3);
    }

        protected Action getAction(int a) {
            if (a < 0) { throw new IllegalArgumentError(); }
            else if (a < 143) { return Action.FUNCTION_0; }
            else if (a < 144) { return Action.FUNCTION_1; }
            else if (a < 153) { return Action.FUNCTION_2; }
            else if (a < 154) { return Action.FUNCTION_3; }
            else { throw new IllegalArgumentError(); }
        }
}
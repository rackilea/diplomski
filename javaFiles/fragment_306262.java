class Foo {
    private volatile State state = new State(0, 0, 0);

    private void setState(float sh1, float sh2, float sh3) {
        state = new State(sh1, sh2, sh3);
    }

    public void run() {
        while (true) {
            State snapshot = state;
            // then do tons of stuff that uses sh1, sh2, sh3 over and over...
        }
    }

    private class State {
        public final float sh1, sh2, sh3;

        State(float sh1, float sh2, float sh3) {
            this.sh1 = sh1;
            this.sh2 = sh2;
            this.sh3 = sh3;
        }
    }
}
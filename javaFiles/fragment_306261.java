class Foo {
    private final AtomicReference<State> state = new AtomicReference<State>(new State(0, 0, 0));

    private void setState(float x1, float x2, float x3) {
        State current;
        State updated;
        do {
            current = state.get();
            // modify the values
            float sh1 = current.sh1 + x1;
            float sh2 = current.sh2 + x2;
            float sh3 = current.sh3 + x3;
            updated = new State(sh1, sh2, sh3);
        } while (!state.compareAndSet(current, updated));
    }

    public void run() {
        while (true) {
            State snapshot = state.get();
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
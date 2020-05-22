public enum State {

    S1 {
        @Override
        State doSomething() {
            // Do something useful
            return S2;
        }
    },
    S2 {
        @Override
        State doSomething() {
            // Do something useful
            return S3;
        }
    },
    // ...
    SN {
        @Override
        State doSomething() {
            // Do something useful
            return S1;
        }
    },
    abstract State doSomething();
}
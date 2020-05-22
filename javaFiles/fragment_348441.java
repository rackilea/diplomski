interface Actor {
    void doSomething();
}

enum Enum1 implements Actor {
    ONE {
        public void doSomething() { . . . }
    },
    TWO {
        public void doSomething() { . . . }
    },
    THREE {
        public void doSomething() { . . . }
    }
}

enum Enum2 implements Actor {
    FOUR {
        public void doSomething() { . . . }
    },
    FIVE {
        public void doSomething() { . . . }
    }
}
public enum Detailed {
    PASSED {
        @Override
        Simple asSimple() {
            return DONE;
        }
    },
    INPROCESS {
        @Override
        Simple asSimple() {
            return RUNNING;
        }
    },
    ERROR1,
    ERROR2,
    ERROR3;
    public Simple asSimple() {
        return Simple.ERROR; // default mapping
    }
}
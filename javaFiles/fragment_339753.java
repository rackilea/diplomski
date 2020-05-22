public enum Direction {

    UNKNOWN,
    FORWARD,
    BACKWARD;

    public interface SwitchResult {
        public void UNKNOWN();
        public void FORWARD();
        public void BACKWARD();
    }

    public void switchValue(SwitchResult result) {
        switch (this) {
            case UNKNOWN:
                result.UNKNOWN();
                break;
            case FORWARD:
                result.FORWARD();
                break;
            case BACKWARD:
                result.BACKWARD();
                break;
        }
    }
}
public class StateAwareBoolean {

        private boolean oldState = false;
        private boolean currentState;

        public StateAwareBoolean(boolean value) {
            currentState = value;
        }

        public void set(boolean newState) {
            oldState = currentState;
            currentState = newState;
        }

        public boolean oldState() {
            return oldState;
        }

        public boolean currentState() {
            return currentState;
        }
    }
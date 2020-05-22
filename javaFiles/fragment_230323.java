public class TransitionTable<T extends Script<?>> {
    private Map<T, StateNode> entries = new HashMap<>()
    private StateNode current, start;

    public T getCurrentState() {
        return current.state;
    }

    public StateNode createNode(T state) {
        StateNode entry = new StateNode(state);
        entries.put(state, entry);

        if (startNode == null) {
            startNode = currentNode = entry;
        }
        return entry;
    }

    public class StateNode {
        private ArrayList<T> nodes = new ArrayList<>();
        private T state;

        private StateNode(T state) {
            this.state = state;
        }

        public StateNode addTransition(T state) {
            nodes.add(state);
            return this;
        }
    }
}
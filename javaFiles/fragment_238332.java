public class Lexicon {
    class State {
        public long count = 0;
        public long stateNo;
        public Set<Arc> arcs;
    }

    class Arc {
        public char character;
        public State destState;
        public Set<String> letters;
    }

    Set<State> states = new HashSet<State>();

    public void update(long stateNo, char character, String letter) {
        for (State state : states) {
            if(state.stateNo == stateNo) {
                for (Arc arc : state.arcs) {
                    if (arc.character == character) {
                        arc.letters.add(letter);
                        break;
                    }
                }
                break;
            }
        }
    }
}
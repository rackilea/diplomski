public class Lexicon {
    class State {
        public long count = 0;
        public long stateNo;
        public Map<Character, Arc> arcs;

        public void updateArc(char character, String letter) {
            Arc arc = arcs.get(character);
            if (arc != null) {
                arc.letters.add(letter);
            }
        }
    }

    class Arc {
        public char character;
        public State destState;
        public Set<String> letters;
    }

    Map<Long, State> states = new HashMap<Long, State>();

    public void update(long stateNo, char character, String letter) {
        State state = states.get(stateNo);
        if (state != null) {
            state.updateArc(character, letter);
        }
    }
}
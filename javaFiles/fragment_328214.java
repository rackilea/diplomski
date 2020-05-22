public class Main {

    private static class StateFrame {
        int matched;
        StateFrame previous;
    }

    private static int count(String cad) {
        StateFrame state = new StateFrame();
        final int len = cad.length();
        int result = 0;
        for (int i = 0; i < len; i++) {
            final char ch = cad.charAt(i);
            if (ch == 'R') {
                if (state.matched == 0) {
                    state.matched = 1;
                } else {
                    StateFrame next = new StateFrame();
                    next.previous = state;
                    state = next;
                    state.matched = 1;
                }
            } else if (ch == 'A') {
                if (state.matched == 1) {
                    state.matched = 2;
                } else {
                    state.previous = null;
                    state.matched = 0;
                }
            } else if (ch == 'V') {
                if (state.matched == 2) {
                    result++;
                    if (state.previous == null) {
                        state.matched = 0;
                    } else {
                        state = state.previous;
                    }
                } else {
                    state.previous = null;
                    state.matched = 0;
                }
            } else {
                state.previous = null;
                state.matched = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] arr = new String[] { "RARAVV", "VAR", "RAVV", "RRAVRXXXAV", "RARRAVAVV", "RRAVARAVV", "RRARAVVARAVV" };
        for (String anArr : arr) {
            System.out.printf("%s %d%n", anArr, count(anArr));
        }
    }
}
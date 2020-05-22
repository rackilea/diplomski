public class StatefulMatcher {

    private Matcher matcher;
    private CharSequence input;
    private boolean matchDone;

    public StatefulMatcher(Pattern pattern, String input) {
        this.input = input;
        this.matcher = pattern.matcher(input);
    }

    public void reset(CharSequence input) {
        this.input = input;
        this.matcher.reset(input);
        this.matchDone = false;
    }

    public boolean matches() {
        matchDone = true;
        return matcher.matches();
    }

    public boolean isMatchDone() {
        return matchDone;
    }

    public CharSequence getInput() {
        return input;
    }

    // other methods
}
public class Bracket {
    int location;
    char bracket;

    public Bracket(int loc, char b) {
        location = loc;
        bracket = b;
    }

    public char getBracket() { return bracket; }
            public int getLoc() { return location; }

    public static boolean isStarter(char b) {
        return b == '(' || b == '{'; // || etc....
    }

    public boolean equals(Bracket other) {
        return bracket == other.getBracket();
    }

    public char getMatching() {
        switch(bracket) {
            case '(': return ')';
            // so on and so forth
        }
    }

    public boolean matches(char other) {
      return (getMatching() == other);
    }
}
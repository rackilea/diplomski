static final Pattern WORD = Pattern.compile("\\G[a-zA-Z]+");
static final Pattern NUMBER = Pattern.compile("\\G\\d+");
static final Pattern LEFT = Pattern.compile("\\G\\{");
static final Pattern RIGHT = Pattern.compile("\\G\\}");
static final Pattern QUOTES = Pattern.compile("\\G\"");
static final Pattern QUOTED_CHARS = Pattern.compile("\\G[^\"]*");
static final Pattern WHITESPACE = Pattern.compile("\\G\\s*");

public static void main(String[] args) {

    String s = "WOrd 023 \"\"{dOor \"knob!\"}";
    Scanner sc = new Scanner(s);

    while (true) {

        sc.skip(WHITESPACE);
        if (!sc.hasNext()) {
            break;
        }

        String token;

        if ((token = sc.findWithinHorizon(WORD, 0)) != null) {
            System.out.println("word: " + token);
        } else if ((token = sc.findWithinHorizon(NUMBER, 0)) != null) {
            System.out.println("number: " + token);
        } else if ((token = sc.findWithinHorizon(LEFT, 0)) != null) {
            System.out.println("left: " + token);
        } else if ((token = sc.findWithinHorizon(RIGHT, 0)) != null) {
            System.out.println("right: " + token);
        } else if ((token = sc.findWithinHorizon(QUOTES, 0)) != null) {
            token = sc.findWithinHorizon(QUOTED_CHARS, 0);
            System.out.println("quoted: '" + token + "'");
            sc.findWithinHorizon(QUOTES, 0);
        }
    }
}
public enum Action {
    DoNotPrint('0'),
    Print('1'),
    PrintAndForward('2'),
    PrintAndReply('3'),
    Forward('F'),
    Reply('R');

    private static Map<Character, Action> map = new HashMap<Character, Action>() {{
        for (Action action : Action.values()) {
            put(action.getChar(), action);
        }
    }};

    private final char c;

    private Action(char c) {
        this.c = c;
    }

    public char getChar() {
        return c;
    }

    public static Action parse(char c) {
        if (!MapHolder.map.containsKey(c))
            throw new IllegalArgumentException("Invalid char: " + c);
        return MapHolder.map.get(c);
    }
}
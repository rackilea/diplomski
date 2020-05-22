public class Repeated<T> implements Pict {

    ...

    private static class RepeatedChars extends Repeated<Character> {
        //see above
    }

    public static Repeated<Character> makeForChars(Character[][] chars) {
        return new RepeatedChars(chars);
    }
}
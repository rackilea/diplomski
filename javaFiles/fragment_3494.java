public class Bird {
    private static last_id = 0;
    private int id ;
    private String kind;
    public Bird(String requiredKind) {
        id = last_id++;
        kind = requiredKind;
    }
    // ...
}
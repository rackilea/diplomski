import java.util.ArrayList;

public class Main {
    String currentIndex;
    private ArrayList<Character> rotorType = new ArrayList<Character>();
    private ArrayList<Character> control = new ArrayList<Character>();

    static final char[] alpha = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G',
        'H', 'I', 'J', 'K', 'L', 'M', 'N',
        'O', 'P', 'Q', 'R', 'S', 'T', 'U',
        'V', 'W', 'X', 'Y', 'Z'};

    static final char[] I = {
        'E', 'K', 'M', 'F', 'L', 'G', 'D', 'Q',
        'V', 'Z', 'N', 'T', 'O', 'W', 'Y', 'H',
        'X', 'U', 'S', 'T', 'A', 'I', 'B', 'R',
        'C', 'J'};

    public Main(char[] rotor) {
        assert (alpha.length == rotor.length) : "rotor must be of same length as alpha.";
        for (int idx = 0; idx < alpha.length; ++idx) {
            rotorType.add(rotor[idx]);
            control.add(alpha[idx]);
        }
    }

    public void convert(char nextCharacter) {
        currentIndex = String.valueOf(rotorType.get(control.indexOf(nextCharacter)));
    }
}
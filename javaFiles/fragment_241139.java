public class Password implements CharSequence {

    private final char[] pass;
    private final BitSet nulled;

    Password(char[] pass) {
        this.pass = pass;
        nulled = new BitSet(pass.length);
    }

    private void nullify(int start, int end) {
        for (int i = start; i < end; i++) {
            pass[i] = '\0';
        }
        nulled.set(start, end);
    }

    @Override
    public int length() {
        return pass.length;
    }

    @Override
    public char charAt(int index) {
        if (nulled.get(index)) {
            // throw some Exception("That character has already been read!")
        }
        char ret = pass[index];
        pass[index] = '\0';
        nulled.set(index);
        return ret;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (nulled.get(start, end).cardinality() > 0) {
            // throw some Exception("Some of the characters has already been read!")
        }
        Password subPass = new Password(Arrays.copyOfRange(pass, start, end)); 
        nullify(start, end);
        return subPass;
    }

    @Override
    public String toString() {
        if (nulled.cardinality() > 0) {
            // throw some Exception("Some of the characters has already been read!")
        }
        String str = new String(pass);
        nullify(0, pass.length);
        return str;
    }

}
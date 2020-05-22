public class AsciiID {
    private static final String alphabet= 
                   "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private int currentId;

    public String nextId() {
        int id = currentId++;
        StringBuilder b = new StringBuilder();
        do {
            b.append(alphabet.charAt(id % alphabet.length()));
        } while((id /=alphabet.length()) != 0);

        return b.toString();
    }
}
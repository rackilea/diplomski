public class VowelCons {
    private final String str;
    private final int totalConsonants;
    private final int totalVowels;

    public VowelCons(final String s) {
        this.str = s;
        int totalConsonants = 0;
        int totalVowels = 0;
        if (null != s) {
            for (final char c : s.toCharArray()) {
                switch (c) {
                    case 'A':
                    case 'a':
                    case 'E':
                    case 'e':
                    case 'I':
                    case 'i':
                    case 'O':
                    case 'o':
                    case 'U':
                    case 'u':
                        totalVowels++;
                        break;
                    default:
                        if (Character.isAlphabetic(c)) {
                            totalConsonants++;
                        }
                        break;
                }
            }
        }
        this.totalConsonants = totalConsonants;
        this.totalVowels = totalVowels;
    }

    public String getString() {
        return str;
    }

    public int getTotalConsonants() {
        return this.totalConsonants;
    }

    public int getTotalVowels() {
        return this.totalConsonants;
    }

    public String toString() {
        return (null == str ? "" : str) + " [consonants=" + totalConsonants + ", vowels=" + totalVowels + "]";
    }

    public static void main(final String[] args) {
        for (final String arg : args) {
            final VowelCons vc = new VowelCons(arg);
            System.out.println(vc.toString());
        }
    }
}
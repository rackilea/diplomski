public class Tokenizer {

    public static void main(String[] args) {

        // true, false, ^ &, !, (, )
        String SYMBOLS = "^&!()";

        String line = "true&!(false^true)";
        List<String> tokens = new ArrayList<String>();

        char[] in = line.toCharArray();
        for (int i = 0; i<in.length; i++) {
            if (in[i] == ' ')
                continue;
            if (SYMBOLS.indexOf(in[i]) >= 0) {
                tokens.add(String.valueOf(in[i]));
            } else if (in[i] == 't') {
                tokens.add("true");
                i += "true".length()-1;
            } else if (in[i] == 'f') {
                tokens.add("false");
                i += "false".length()-1;
            }
        }

        for (String token : tokens)
            System.out.println(token);

    }
}
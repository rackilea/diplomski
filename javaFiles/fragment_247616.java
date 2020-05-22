public class Run {
    public static void main(String[] args) {
        String string = "I love stack overflow very much";

        //replacing all newline and and then making tokens
        String[] words = string.replaceAll("\\s", "").split("(?<=\\G.{8})");

        for (String st : words) {
            if (st.length() == 8) { // if length of the string is 8, just print the string
                System.out.println(st);
            } else {
                System.out.print(st);

                // printing dummy characters after the final string
                for (int i = 0; i < 8 - st.length(); i++) {
                    System.out.print("X"); // assuming dummy character = X;
                }
            }
        }

        System.out.println("\n");

        // Reverse
        for (String st : words) {
            if (st.length() == 8) {
                System.out.println(new StringBuilder(st).reverse().toString());
            } else {
                String revString = st;
                for (int i = 0; i < 8 - st.length(); i++) {
                    revString += "X";
                }
                System.out.println(new StringBuilder(revString).reverse().toString());
            }
        }
    }
}
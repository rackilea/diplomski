public class splitStrRegex {

    public static void main(String[] args) {

        String myStr = ":if[input=right || input=Right && input != null]:";
        String[] myStrings = myStr.split("\\|\\||&&");
        for(int i = 0; i < myStrings.length; i++) {
            System.out.println(myStrings[i].trim());
        }
    }
}
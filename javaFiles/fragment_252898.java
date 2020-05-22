public class Main {

    public static void main(String[]args) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher("138fj*28+/dg");

        if (matcher.matches()) {
            System.out.println(true);
            // number
        }else {
            System.out.println(false);
            // not
        }
    }
}
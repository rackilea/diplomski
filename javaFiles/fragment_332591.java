public class third {

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);

        System.out.println("Enter a name:\n");
        String first_name = user_input.next();
        String last_name = user_input.next();

        Map<String, String> salutations = new HashMap<String, String>();
        salutations.put("Amy".toLowerCase(), "MS");
        salutations.put("Buffy".toLowerCase(), "MS");
        salutations.put("Cathy".toLowerCase(), "MS");
        salutations.put("Elory".toLowerCase(), "MR");
        salutations.put("Fred".toLowerCase(), "MR");
        salutations.put("Graham".toLowerCase(), "MR");

        String salutation = null;
        if (first_name != null) {
            salutation = salutations.get(first_name.toLowerCase());
        }

        if (salutation != null) {
            System.out.println(String.format("%s. %s %s", salutation, first_name, last_name));
        } else {
            System.out.println(first_name + " " + last_name);
        }

    }
}
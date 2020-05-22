public static void main(String[] args) {

    String example = "AbcDefGhi12345";

    if (example.matches("(([A-Z][a-z]+)+)([0-9]+)")) {

        Scanner s = new Scanner(example);

        String m;
        while ((m = s.findWithinHorizon("[A-Z][a-z]+", 0)) != null)
            System.out.println(m);

        System.out.println(s.findWithinHorizon("[0-9]+", 0));
    }
}
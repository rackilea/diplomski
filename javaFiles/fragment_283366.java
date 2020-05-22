final class LoginValidator {

    private final Map<String, String> map = new HashMap<>();

    public LoginValidator(InputStream in) {
        try (Scanner scan = new Scanner(in)) {
            scan.useDelimiter("[,\n]");

            while (scan.hasNextLine()) {
                map.put(scan.next(), scan.next());
                scan.nextLine();
            }
        }
    }

    public boolean isValid(String email, String password) {
        return map.containsKey(email) && map.get(email).equals(password);
    }
}
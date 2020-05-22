private static final String SPECIAL_CHARACTERS = "(`~!@#$%^&*()_+=-\\]\\[;'/.,\\<>?|:\"}{)";

public static void main(String[] args) {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    try {
        String password = in.readLine();
        if(!password.matches("((?=.*\\d)(?=.*["+SPECIAL_CHARACTERS+"]).{8,})")){
            System.out.println("Password does not satisfy compliant");
        } else {
            System.out.println("Yes.. gets through");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public static void main(String[] args) throws IOException
{
    String alpha = "ABCDEFG1234567890";

    for (int i = 0; i < alpha.length(); i++) {
        char c = alpha.charAt(i);

        if (Character.isDigit((c))) {
            System.out.println(c);
        } else {
            System.out.println((int)c - 55); // Cast to 'int'
        }
    }
}
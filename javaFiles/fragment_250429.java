class GenLookup {
    public static void main(String args[]) {
        long a = 1, b = 3, c;
        System.out.print ("long lookup[] = { " + a + "L, " + b + "L");
        c = 3 * b - a;
        while ((c + a) / 3 == b) {
            System.out.print (", " + c + "L");
            a = b; b = c; c = 3 * b - a;
        }
        System.out.println (" };");
    }
}
class Main {

    static void string_recurse(String active,String rest) {
        if (rest.length() == 0) {
            System.out.println(active);
        } else {
            string_recurse(active + rest.charAt(0), rest.substring(1, rest.length()));
            string_recurse(active, rest.substring(1, rest.length()));
        }
    }

    static void string_iterative(String s) {
        int n = s.length();
        for (int mask = (1 << n) - 1; mask >= 0; mask--) {
            String temp = "";
            for (int pos = 0; pos < n; pos++)
                if (((1 << (n - 1 - pos)) & mask) != 0)
                    temp += s.charAt(pos);
            System.out.println(temp);               
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        string_recurse("", s);
        string_iterative(s);
    }
}
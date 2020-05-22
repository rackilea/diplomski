public static String reverseString(String str) {
        String reverse = "";
        if (str.length() == 1) {
            System.out.println("hi");
            return str; // at one point this condition will be true, but value never returns
        } else {
            reverse += str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
            return reverse;
        }
    }

    public static void main(String a[]) {
        System.out.println(reverseString("Test"));
    }
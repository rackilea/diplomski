public static void main(String[] args) {
        String base = "FLAMES";
        int value = 1;
        value--;
        value = value % base.length();
        System.out.println(base.charAt(value));
     }
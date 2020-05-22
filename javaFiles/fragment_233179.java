public static void main(String[] args) {
        int a = 123456;

        String s = Integer.toString(a);
        for (int i = 0; i < s.length() - 1; i++) {
            System.out.print(s.charAt(i) + ",");
        }
        System.out.println(s.charAt(s.length() - 1));
    }
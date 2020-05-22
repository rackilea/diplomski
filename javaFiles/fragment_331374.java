public static void main(String[] args) {
        String str = "hello";
        System.out.println(str);
        char[] strchar = str.toCharArray();
        int first;
        int last = 4;

        System.out.println("The reversed is: ");
        for (first = 0; first < 5; first++) {
            strchar[first] = str.charAt(last);

            last--;

        }
        str = String.valueOf(strchar);
        str = str.toUpperCase();
        System.out.println(str);

    }
public static void main(String[] args) {
        String encoded = e("ABDSDfz}", 2, true);
        System.out.println(encoded);
        String decoded = e(
encoded.substring(0, encoded.indexOf("`")),
                -Integer.parseInt(encoded.substring(encoded.indexOf("`") + 1)),
                false);
        System.out.println(decoded);

    }
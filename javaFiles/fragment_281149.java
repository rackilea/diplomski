public static int encode(String file) {
        int hash = 0;
        file = file.toUpperCase();

        for(int i = 0; i < file.length(); i++) {
                hash = (hash * 61 + file.charAt(i)) - 32;
        }
        return hash;
}
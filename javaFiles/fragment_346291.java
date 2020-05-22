public String compres(String txt) {

        StringBuilder dst = new StringBuilder();
        char character;
        int count;

        for (int i = 0; i < txt.length(); i++) {
            character = txt.charAt(i);
            count = 1;
            while (i < txt.length() - 1 && txt.charAt(i + 1) == character) {
                count++;
                i++;
            }
            System.out.print(character);
            System.out.print(count);
            dst.append(character).append(count);
        }

        return dst.toString();
}
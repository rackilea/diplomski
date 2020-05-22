public static void wrapText(String text, int width) {
    int count = 0;

    for (String word : text.split("\\s+")) {
        if (count + word.length() >= width) {
            System.out.println();
            count = 0;
        }

        System.out.print(word);
        System.out.print(' ');

        count += word.length() + 1;
    }
}
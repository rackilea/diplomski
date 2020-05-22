public static void average( char [] letter ) {

    for (int i = 0; i < letter.length; i++) {
        letter[i] = Character.toLowerCase(letter);
    }

    System.out.println(Arrays.toString(letter));
}
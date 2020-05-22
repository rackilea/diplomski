public static void main(String... args) {
    StringBuilder sb = new StringBuilder("abcdefghijkl");
    for (int i = 0; i < 5; i++) {
        shuffle(sb);
        System.out.println(sb);
    }
}


public static void shuffle(StringBuilder sb) {
    Random rand = new Random();
    for (int i = sb.length() - 1; i > 1; i--) {
        int swapWith = rand.nextInt(i);
        char tmp = sb.charAt(swapWith);
        sb.setCharAt(swapWith, sb.charAt(i));
        sb.setCharAt(i, tmp);
    }
}
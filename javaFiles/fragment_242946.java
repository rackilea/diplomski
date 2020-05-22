private static void charRange(int i) {
    char c = (char) i;
    System.out.println(" --> " + (int) c);
}

charRange(65);
charRange(Character.MAX_VALUE + 20);
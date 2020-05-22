public static void main(String[] args) {
    System.out.println(generatePattern(1, 10));
    System.out.println(generatePattern(2, 10));
    System.out.println(generatePattern(3, 10));
    System.out.println(generatePattern(4, 10));
}

public static String generatePattern(int count, int length) {
    int frequency = length / count;
    StringBuilder pattern = new StringBuilder();
    for (int i = 0; i < length; i++) {
        pattern.append(i % frequency == 0 && i < frequency * count ? 'X' : '0');
    }
    return pattern.toString();
}
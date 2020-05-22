private String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGRHIJKLMNOPQRSTUVWXYZ0123456789";

public String getRandomValue(int min, int max) {
    Random random = new Random();
    int length = random.nextInt(max - min + 1) + min;
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < length; i++) {
        sb.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
    }
    return sb.toString();
}
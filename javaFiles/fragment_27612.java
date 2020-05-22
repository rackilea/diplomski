public static void main(String[] args) {
    String phone = "1234567890";
    long seed = Long.valueOf(phone) * 1000 + System.currentTimeMillis() % 1000L;
    System.out.println(generateRandomPassword(seed));
}

public static String generateRandomPassword(long seed) {
    Random random = new SecureRandom();
    random.setSeed(seed);
    int CODE_LENGTH = 8; // Make this static

    Long randomLong = random.nextLong();
    String pw =  Long.toString(randomLong).substring(1, CODE_LENGTH+1); // 
    return pw ; 

    //simplified 
    //return Long.toString(random.nextLong()).substring(1, CODE_LENGTH+1);
}
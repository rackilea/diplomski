private static final String CHARACTER_SET = "23456789abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ";
private static Random rnd = new Random();

public static String randomString(int length){
    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < length; i++){
        builder.append(CHARACTER_SET.charAt(rnd.nextInt(CHARACTER_SET.length())));
    }
    return builder.toString();
}
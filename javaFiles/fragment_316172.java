public static String generate()
{
    Random r = new Random(); // create a Random object
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 2 + 1; i++) {
        for (int j = 0; j < 2 + 1; j++) {
            if (r.nextBoolean()) {  // r.nextBoolean() return 'true' or 'false'
                stringBuilder.append("X");
            } else {
                stringBuilder.append("O");
            }
        }
        stringBuilder.append(" ");
    }
    String finalString = stringBuilder.toString();
    return finalString; // return stringBuilder.toString();
}
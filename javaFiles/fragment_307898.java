import java.util.Random

private String generateRegistration() {
    String selectFrom1 = "ABCDEFGHIJKLMNOPRSTUVWXYZ";
    String selectFrom2 = "0123456789";
    String selectFrom3 = selectFrom1.toLowerCase();

    return randomFromSelection(selectFrom1,2)+"-"+randomFromSelection(selectFrom2,10)+randomFromSelection(selectFrom3,2)
}
private String randomFromSelection(String selection, int times) {
    Random random = new Random();
    String toReturn = "";
    for (int useless = 0; useless < times; useless++) {
        toReturn += selection.charAt(random.nextInt(selection.length()));
    }
    return toReturn;
}
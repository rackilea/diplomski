public void callPhoneNumber(Context context, String number) {
    ...
    number = "tel:" + replaceLettersInNumber(number);
    context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(number)));
    ...
}

public static String replaceLettersInNumber(String number) {
    return number
        .replaceAll("[ABCabc]", "2")
        .replaceAll("[DEFdef]", "3")
        .replaceAll("[GHIghi]", "4")
        .replaceAll("[JKLjkl]", "5")
        .replaceAll("[MNOmno]", "6")
        .replaceAll("[PQRSpqrs]", "7")
        .replaceAll("[TUVtuv]", "8")
        .replaceAll("[WXYZwxyz]", "9");
}
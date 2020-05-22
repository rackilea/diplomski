public static String preprocess(String date) {
    int pIndex = date.lastIndexOf(".") + 1;
    String millis = date.substring(pIndex);
    for (int i = millis.length(); i < 3; i++)
        millis += "0";
    return date.substring(0, pIndex) + millis;
}
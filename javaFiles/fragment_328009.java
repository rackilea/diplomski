public static String preprocess(String date) {
    String millis = date.substring(date.lastIndexOf(".") + 1);
    for (int i = millis.length(); i < 3; i++)
        date += "0";
    return date;
}
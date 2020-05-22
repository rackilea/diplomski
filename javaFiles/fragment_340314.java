public static String removeDiacritics(String input) {
    String out = "" + input;
    out = out.replaceAll(" ", "");
    out = out.replaceAll("[èéêë]", "e");
    out = out.replaceAll("[ûù]", "u");
    out = out.replaceAll("[ïî]", "i");
    out = out.replaceAll("[àâ]", "a");
    out = out.replaceAll("Ô", "o");

    out = out.replaceAll("[ÈÉÊË]", "E");
    out = out.replaceAll("[ÛÙ]", "U");
    out = out.replaceAll("[ÏÎ]", "I");
    out = out.replaceAll("[ÀÂ]", "A");
    out = out.replaceAll("Ô", "O");

    out = out.replaceAll("-", "");

    return out;
}
public static String toVar(String str){
    str = str.replaceAll("^[^a-zA-Z_]+", "");
    str = str.replaceAll("[^a-zA-Z_0-9]+", "_");
    str = str.replaceAll("(?<=[a-z])(?=[A-Z])", "_");
    return str.toUpperCase();
}
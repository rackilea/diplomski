public static boolean isHexadecimal(String blobdata) {

    Pattern p = Pattern.compile("[^0-9a-fA-F]");
    Matcher m = p.matcher(blobdata);

    if (m.matches()) {
        return false;
    }
    return true;
}
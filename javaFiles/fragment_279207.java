private static boolean subEquals(String large, int offset, String small) {
    for (int i = 0; i < small.length(); i++)
        if (large.charAt(offset + i) != small.charAt(i))
            return false;
    return true;
}
public static boolean checkSubset(String large, String small) {
    for (int i = 0; i <= large.length() - small.length(); i++)
        if (subEquals(large, i, small))
            return true;
    return false;
}
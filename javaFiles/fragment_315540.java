public static int[] tabCards() {
    int result = new int[41];
    for (int i = 0; i < result.length; i++) {
        result[i] = getResources().getIdentifier("title_section" + i, "string", getPackageName());
    }
    return result;
}
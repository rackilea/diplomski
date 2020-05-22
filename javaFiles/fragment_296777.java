public static int indexOf(CharSequence input, String needle) {
    if (input instanceof String) {
        String text = (String) input;
        return text.indexOf(needle);
    }
    if (input instanceof StringBuilder) {
        StringBuilder text = (StringBuilder) input;
        return text.indexOf(needle);
    }
    // TODO: Do this without calling toString() :)
    return input.toString().indexOf(needle);
}
public static String myMagicToString(final Object in) throws IllegalArgumentException, IllegalAccessException {
    final StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(in.getClass().getSimpleName()).
            append(" [");
    for (final Field field : in.getClass().getDeclaredFields()) {
        field.setAccessible(true);
        stringBuilder.append(field.getName()).
                append("=").
                append(field.get(in)).
                append(",");
    }
    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    stringBuilder.append("]");
    return stringBuilder.toString();
}
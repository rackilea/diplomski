public String transformToNormalizedDateFormat(final String input) {
    String[] components = input.split("-");
    String month = components[0];
    if(month.length() > 3) {
        throw new IllegalArgumentException("Was not a date in \"MMM\" format: " + month);
    }
    // Only capitalize the first letter.
    final StringBuilder builder = new StringBuilder();
    builder.append(month.substring(0, 1).toUpperCase())
            .append(month.substring(1).toLowerCase())
            .append("-");
    final StringJoiner stringJoiner = new StringJoiner("-");
    Arrays.stream(components, 1, components.length).forEach(stringJoiner::add);
    builder.append(stringJoiner.toString());
    return builder.toString();
}
private String removeAttrSpaces(final String str) {

    final StringBuilder sb = new StringBuilder(str.length());
    boolean inAttribute = false;
    for (final String segment : str.split(" ")) {

        if (segment.startsWith("alt=\"") || segment.startsWith("src=\"")) {

            inAttribute = true;
        }
        if (inAttribute && segment.endsWith("\"")) {

            inAttribute = false;
        }

        sb.append(segment);
        if (!inAttribute) {

            sb.append(' ');
        }
    }

    return sb.toString();
}
public String escape(final String s) {
    return s.codePoints()
        .mapToObj(codePoint -> codePoint > 127 ?
            "&#x" + Integer.toHexString(codePoint) + ";" :
             new String(Character.toChars(codePoint)))
    .collect(Collectors.joining());
}
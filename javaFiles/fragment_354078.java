public static boolean isValidHtmlEscapeCode(String string) {
    if (string == null) {
        return false;
    }
    Pattern p = Pattern
            .compile("&(?:#x([0-9a-fA-F]+)|#([0-9]+)|([0-9A-Za-z]+));");
    Matcher m = p.matcher(string);

    if (m.find()) {
        int codePoint = -1;
        String entity = null;
        try {
            if ((entity = m.group(1)) != null) {
                if (entity.length() > 6) {
                    return false;
                }
                codePoint = Integer.parseInt(entity, 16);
            } else if ((entity = m.group(2)) != null) {
                if (entity.length() > 7) {
                    return false;
                }
                codePoint = Integer.parseInt(entity, 10);
            } else if ((entity = m.group(3)) != null) {
                return namedEntities.contains(entity);
            }
            return 0x00 <= codePoint && codePoint < 0xd800
                    || 0xdfff < codePoint && codePoint <= 0x10FFFF;
        } catch (NumberFormatException e) {
            return false;
        }
    } else {
        return false;
    }
}
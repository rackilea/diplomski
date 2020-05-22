/**
 * Remove any diacritical marks (accents like ç, ñ, é, etc) from
 * the given string (so that it returns plain c, n, e, etc).
 * @param string The string to remove diacritical marks from.
 * @return The string with removed diacritical marks, if any.
 */
public static String removeDiacriticalMarks(String string) {
    return Normalizer.normalize(string, Form.NFD)
        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
}
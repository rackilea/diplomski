/**
 * Function to strip control characters from a string.
 * Any character below a space will be stripped from the string.
 * @param iString the input string to be stripped.
 * @return a string containing the characters from iString minus any control characters.
 */
public String stripControlChars(String iString) {
    StringBuffer result = new StringBuffer(iString);
    int idx = result.length();
    while (idx-- > 0) {
        if (result.charAt(idx) < 0x20 && result.charAt(idx) != 0x9 && 
                result.charAt(idx) != 0xA && result.charAt(idx) != 0xD) {
            if (log.isDebugEnabled()) {
                log.debug("deleted character at: "+idx);
            }
            result.deleteCharAt(idx);
        }
    }
    return result.toString();
}
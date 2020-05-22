static String[] partition(String s, String regex) {
    Matcher m = Pattern.compile(regex).matcher(s);
    if (m.find()) {
        return new String[] {
            s.substring(0, m.start()),
            m.group(),
            s.substring(m.end()),
        };
    } else {
        throw new NoSuchElementException("Can't partition!");
    }
}
public static void main(String[] args) {
    dump(partition("james007bond111", "\\d+"));
    // prints "[james][007][bond111]"
}
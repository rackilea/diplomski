StringBuilder sb = new StringBuilder(toReplace);
int first = toReplace.indexOf("'"), last = toReplace.lastIndexOf("'");
if (first != last) {
    for (int i = first + 1; i < last; i++) {
        if (sb.charAt(i) == '\'') {
            sb.insert(i, '\'');
            i++;
        }
    }
}
toReplace = sb.toString();
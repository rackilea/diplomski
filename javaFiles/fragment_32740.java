public static boolean isFiltered(String data, String filter) {
    // no filter: return true
    if (StringUtils.isBlank(filter)) {
        return true;
    }
    // a filter but no data: return false
    else if (StringUtils.isBlank(data)) {
        return false;
    }
    // a filter and a data:
    else {
        // case insensitive
        data = data.toLowerCase();
        filter = filter.toLowerCase();
        // .matches() auto-anchors, so add [*] (i.e. "containing")
        String regex = "*" + filter + "*";
        // replace any pair of backslashes by [*]
        regex = regex.replaceAll("(?<!\\\\)(\\\\\\\\)+(?!\\\\)", "*");
        // minimize unescaped redundant wildcards
        regex = regex.replaceAll("(?<!\\\\)[?]*[*][*?]+", "*");
        // escape unescaped regexps special chars, but [\], [?] and [*]
        regex = regex.replaceAll("(?<!\\\\)([|\\[\\]{}(),.^$+-])", "\\\\$1");
        // replace unescaped [?] by [.]
        regex = regex.replaceAll("(?<!\\\\)[?]", ".");
        // replace unescaped [*] by [.*]
        regex = regex.replaceAll("(?<!\\\\)[*]", ".*");
        // return whether data matches regex or not
        return data.matches(regex);
    }
}
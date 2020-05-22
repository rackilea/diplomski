final Pattern itemModelRegEx = Pattern.compile(
        "^(item1|item2|item3|item4)(-)(\\d{4}((0[1-9])|(1[0-2]))(0[1-9]|[1-2][0-9]|3[0-1]))(?:.*)",
        Pattern.CASE_INSENSITIVE);
final Pattern dateRegex = Pattern.compile(
        "(20\\d{2})([0-1]\\d)([0-3]\\d)",
        Pattern.CASE_INSENSITIVE);
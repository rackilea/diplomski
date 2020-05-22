String urlPattern = "(|who|what)\\b.*\\?.*";
 Pattern p = Pattern.compile(urlPattern,Pattern.CASE_INSENSITIVE);
    Matcher m = p.matcher(commentstr);
    if (m.matches()) {                        // < - Here, matches is used
        System.out.println("yes");
    }
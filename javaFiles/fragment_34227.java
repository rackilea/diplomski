try {
    Pattern pattern = Pattern.compile("<pre>(.+?)</pre>");
    Matcher matcher = pattern.matcher(yourText);

    while (matcher.find()) {
        //  matcher.group() will contain the match from the previous find() statement
    }
}
catch(Exception ex){}
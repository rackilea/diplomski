String str = "GET /common/data/register/ HTTP/1.1\" 200 254614 " +
            "https://www.test.com/hiii/ Mozilla/5.0 " +
            "(Windows NT 6.1; WOW64; rv:10.0.8) " +
            "Gecko/20100101 Firefox/ ";

    Pattern pattern = Pattern.compile("HTTP/\\d.\\d\"\\s(\\d{3})");
    Matcher match = pattern.matcher(str);

    while (match.find()) {
        System.out.println(match.group(1));  // Prints 200
    }
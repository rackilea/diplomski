final String srcOne = "<html>\r\n<head>\r\n<script src=\"http://test.com/some.js\"/>\r\n</head></html>";
    final String srcTwo = "<html>\r\n<head>\r\n<script src=\"http://test.com/some.js\"></script>\r\n</head></html>";
    final String tag = "<html>\r\n<head>\r\n<script>\r\nfunction() {\r\n\talert('hi');\r\n}\r\n</script>\r\n</head></html>";
    final String tagAndSrc = "<html>\r\n<head>\r\n<script src=\"http://test.com/some.js\">\r\nfunction() {\r\n\talert('hi');\r\n}\r\n</script>\r\n</head></html>";
    final String[] tests = new String[] {srcOne, srcTwo, tag, tagAndSrc, srcOne + srcTwo, tag + srcOne + tagAndSrc};

    final String regex = "<script(?:[^>]*src=['\"]([^'\"]*)['\"][^>]*>|[^>]*>([^<]*)</script>)";
    final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    for (int testNumber = 0; testNumber < tests.length; ++testNumber) {
        final String test = tests[testNumber];
        final Matcher matcher = pattern.matcher(test);
        System.out.println("--------------------------------");
        System.out.println("TEST " + testNumber + ": " + test);
        while (matcher.find()) {
            System.out.println("GROUP 1: " + matcher.group(1));
            System.out.println("GROUP 2: " + matcher.group(2));
        }
        System.out.println("--------------------------------");
        System.out.println();
    }
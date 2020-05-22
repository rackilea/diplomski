@Test
    public void testX() {
        final String s = "<img src=\"mysrc\" width=\"128\" height=\"92\"...";
        final String regex = "(?<=<img src=\")[^\"]*";
        final Pattern p = Pattern.compile(regex);
        final Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }

    }
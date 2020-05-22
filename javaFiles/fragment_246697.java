String content="aaaaaaaaaa";
        Pattern pattern = Pattern.compile("a");

        Matcher m = pattern.matcher(content);

        String result;

        result = m.replaceFirst("b"); // once!
        result = m.replaceFirst("b"); // twice!
        result = m.replaceFirst("b"); // one more for "good" measure!

        System.out.println(result);
        // baaaaaaaaa
        // i.e. THIS DOES NOT WORK!!!
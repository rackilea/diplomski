String s = "Hello, user.  How many words and sentences are there?  Count them!";

    int words = 0;
    int sentences = 0;
    Pattern pattern = Pattern.compile("(\\w+)|([.?!])");
    Matcher matcher = pattern.matcher(s);

    while(matcher.find()) {
        if (matcher.group(1) != null)
            words++;
        else if (matcher.group(2) != null)
            sentences++;
    }

    System.out.printf("%d words and %d sentences%n", words, sentences);
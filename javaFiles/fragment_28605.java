String s = "name lastname (username) <mail@mail.something.dk>; name lastname
            (username) <mail@mail.something.dk>; name lastname 
            (username) <mail@mail.something.dk>;";

    // Matches (?<=\\()[^\\)]+  or  ((?<=<)[^>]+)
    Pattern pattern = Pattern.compile("(?<=\\()[^\\)]+|((?<=<)[^>]+)");
    Matcher matcher = pattern.matcher(s);

    while (matcher.find()) {
        System.out.println(matcher.group());
    }
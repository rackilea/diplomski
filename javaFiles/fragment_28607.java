String s = "name lastname (username) ; 
                name lastname (username) <mail@mail.something.dk>; 
                name lastname (username) <mail@mail.something.dk>;";

    String [] strArr = s.split(";");

    for (String str: strArr) {

        Pattern pattern = Pattern.compile("\\(([^\\)]+)(?:\\))\\s(?:\\<)((?<=<)[^>]+)");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.print(matcher.group(1) + " " + matcher.group(2));
        }
        System.out.println();
    }
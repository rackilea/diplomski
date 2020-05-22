String text =
        "Line1 blah blah\n" +
        "Line2 more blah blah\n" +
        "Line3 let's try something new \r\n" +
        "Line4 meh\n" + 
        "Line5 bleh\n" + 
        "Line6 bloop\n";
    Scanner sc = new Scanner(text).skip("(?:.*\\r?\\n|\\r){4}");
    while (sc.hasNextLine()) {
        System.out.println(sc.nextLine());
    }
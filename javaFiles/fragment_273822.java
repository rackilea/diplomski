String input = "this \"is a great\" day";

    for (String  word: input.split("(?<=\").+(?=\")|\\b\\w+\\b"))
    {
        System.out.println("["+word+"]");
    }
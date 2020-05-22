String text = "\"text\",\"1\",\"more, more text\",\"3\"";

    String[] split = text.split("\"(,\")?");
    for (String string : split) {
        System.out.println(string);
    }
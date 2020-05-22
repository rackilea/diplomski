public String first(String s) {
    return String.format("first %s", s);
}

public String second(String s) {
    return String.format("second %s", s);
}

public String fmt(String... strings) {
    switch (strings.length) {
        case 0:
            return "Empty";
        case 1:
            return second(strings[0]);
        case 2:
            return first(strings[0])+" "+second(strings[1]);
        default:
            return "What are you doing!!!";
    }
}
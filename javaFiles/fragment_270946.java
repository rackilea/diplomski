public static void main(String[] args) {
    String data = "name: John, random text, address: leetStreet";
    Person person;

    //if regex matches, use method reference, to send the result. 
    applyData(data, "name: (\\w+)", person::setName);
    applyData(data, "address: (\\w+)", person::setAddress);
}

private static void applyData(String data, String regex, Consumer<String> action) {
    Matcher match = Pattern.compile(regex).matcher(data);
    if (match.matches()) action.accept(match.group(1));
}
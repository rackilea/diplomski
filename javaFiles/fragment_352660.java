List<String> list = Arrays.asList("1. Position", "1.1. Position.", "1.2. Scope", "1.3. Location. ",
        "2. Compensation", "2.1. Schedule", "2.2. ", "3. Term", "3.1. Term.", "3.1.i. bla", "3.1.ii. bla bla",
        "12.a. some para", "13.a. some para", "1.a. some para", "A.1.a. another para", "B.1.a. some para");
Pattern p = Pattern.compile("^((?:[a-zA-Z\\d]+\\.)+)\\s+(.*)");

list.stream().forEach(x -> {
    Matcher m = p.matcher(x);
    if (m.matches()) {
        System.out.println(x + " --> " + "number section: ("+m.group(1)+")" + " para section: ("+m.group(2)+")");
    }
});
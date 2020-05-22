List<Person> people = new ArrayList<Person>();

    String regexpStr = "(\\[([0-9]+),\\s*([0-9a-zA-Z]+),\\])";
    String inputData = "[11, john,][23, Adam,][88, Angie,]";

    Pattern regexp = Pattern.compile(regexpStr);
    Matcher matcher = regexp.matcher(inputData);
    while (matcher.find()) {
        MatchResult result = matcher.toMatchResult();

        String id = result.group(2);
        String name = result.group(3);

        Person person = new Person(Long.valueOf(id), name);
        people.add(person);
    }
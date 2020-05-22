List<String> data = Arrays.asList("blah", "foo", "bar", "hello world", "bye bye", "fizz", "buzz");

List<String> sortedDataByLength = sortBy(data, new Function<String, Integer>() {
    @Override
    public Integer apply(String t) {
        return t.length();
    }});
System.out.println(sortedDataByLength);
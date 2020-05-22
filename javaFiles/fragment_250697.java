List<String> words = Arrays.asList("foo", "bar", "hello", "world");

ImmutableListMultimap<Boolean, String> partitionedMap = Multimaps.index(words, new Function<String, Boolean>(){
    @Override
    public Boolean apply(String input) {
        return input.length() > 3;
    }
});
System.out.println(partitionedMap);
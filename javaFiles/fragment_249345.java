public void check() {
    List<String> endPoints = Arrays.asList("http://www.google.com", "http://www.stackoverflow.com", "inexistent");
    {
        // this will execute the requests in parallel
        List<Boolean> collected = performCheckOverStream(endPoints.parallelStream());
        System.out.println(collected);
    }
    {
        // this will execute the requests in serial
        List<Boolean> collected = performCheckOverStream(endPoints.stream());
        System.out.println(collected);
    }

}

private List<Boolean> performCheckOverStream(Stream<String> stream) {
    List<Boolean> collected = stream.map(new Function<String, Boolean>() {
        @Override
        public Boolean apply(String t) {
            // do what you need here
        }
    }).collect(Collectors.toList());
    return collected;
}
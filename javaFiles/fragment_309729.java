Set<String> input; //Given
Collection<String> output = Collections2.transform(input, new Function<String,String>() {
    @Override
    public String apply (String element) {
        // As JohnnyO says, add appropriate edge case checking...
        return element.split(";")[1]; 
    }
});
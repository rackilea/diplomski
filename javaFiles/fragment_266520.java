public static class StringConcat implements BiConsumer<String,String>{
    private List<String> values = new ArrayList<>();

    @Override
    public void accept(String s, String s2) {
        values.add(s,s2);
    }
}
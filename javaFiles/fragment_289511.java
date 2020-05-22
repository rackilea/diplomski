Factory<List<String>> arrayListFactory = new Factory<List<String>>() {
    @Override
    public List<String> newInstance() throws InstantiationException, IllegalAccessException {
        return new ArrayList<String>();
    }
};
Factory<String> stringFactory = new Factory<String>() {
    @Override
    public String newInstance() throws InstantiationException, IllegalAccessException {
        return String.class.newInstance();
    }
};
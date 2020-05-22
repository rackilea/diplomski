Comparator<String> comparator = new Comparator<String>(){

    @Override
    public int compare(String s1, String s2) {
        //TODO define the comparison based on length, and then alphabetically
        return 0;
    }
};
List<String> strings = ...
Collections.sort(strings, comparator);
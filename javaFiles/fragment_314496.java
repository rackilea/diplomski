public static void main(String[] args) {
        Set<StringWrapper> mySet = new HashSet<StringWrapper>();
        mySet.add(new StringWrapper("brain"));
        mySet.add(new StringWrapper("Brain"));
        for (StringWrapper s : mySet) {
            System.out.println(s.myString);
        }
    }
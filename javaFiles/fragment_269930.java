String[] master = { "A", "B", "C", "D", "E" };
String[] child = { "A", "C" };

//convert to lists
List<String> masterList = Arrays.asList(master);
List<String> childList = Arrays.asList(child);

//iterate over the master
for (int i = 0; i < masterList.size(); i++) {
    String m = masterList.get(i);

    //check child contains the master element
    if (childList.contains(m)) {
        //append #
        masterList.set(i, m + '#');
    }
}

//convert to array and create a jList
JList jlist = new JList(masterList.toArray());
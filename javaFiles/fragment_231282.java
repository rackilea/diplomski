TreeSet<String> treeSet = new TreeSet<String>(); 

// you populate treeSet with data

String[] stringArray = new String[NUMBER_OF_NEEDED_RECORDS];
for(int i =0; i < NUMBER_OF_NEEDED_RECORDS; i++) {
    stringArray[i] = treeSet.pollFirst();
}
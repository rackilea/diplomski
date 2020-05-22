for (String x : names){
    String[] temp = x.split(" "); // split "Joe Bloggs" to ["Joe", "Bloggs"]
    if (temp.length == 2){
        snames.put(temp[0], temp[1]); // Mapping "Joe" to "Bloggs"
    }
}
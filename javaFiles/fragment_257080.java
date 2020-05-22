if(line.contains("ID:")){
    if ( hmap1.containsKey(line) ) {
        // get the entry and do something with it
    }
    else { 
        hmap1.put(line, new HashMap<String, ArrayList<String>>());
    }
    Id = line;
}
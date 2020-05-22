public T get(string key){
    Entry e = findEntry(key);
    return e.value;
}

public void put(string key, string value){
    Entry e = addNewEntry(key);
    //danger for get while in-between these lines
    e.value = value;
}

private Entry addNewEntry(key){
   Entry entry = new Entry(key, ""); //a new entry starts with empty string not null!
   addToBuckets(entry); //now it's findable by get
   return entry; 
}
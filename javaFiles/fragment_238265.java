public boolean add(String content) { 
    strings = new String[strings.length+1]; //still erases the internal array!
    strings[0] = content; //only modifies the first element, rather than add to the list
    size = 1; //if it was implemented correctly, this would be size++;
    return true; 
}
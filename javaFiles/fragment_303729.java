public int getIndex(String s){
    for(int i = 0; (i < names.length; i++)
    {
        if(names[i].equals(s)) { //use equalsIgnoreCase if comparing should be case insensitive
            return i; //found
        }        
    }
    return -1; //not found
}
public List<Integer> getIndexes(String s){
    List<Integer> found = new ArrayList<Integer>();
    for(int i = 0; (i < names.length; i++)
    {
        if(names[i].equals(s)) { //use equalsIgnoreCase if comparing should be case insensitive
            found.add(i);
        }        
    }
    return found;
}
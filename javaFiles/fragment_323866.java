// we're using iterator
for (Iterator<String> i = c.iterator(); i.hasNext();) {  
    // here, the collection will check it hasn't been modified (in effort to fail fast)
    String s = i.next();
    if(s.equals("lalala")) {
        // s is removed from the collection and the collection will take note it was modified
        c.remove(s);
    }
}
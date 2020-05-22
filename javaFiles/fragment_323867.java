// we're using iterator
for (Iterator<String> i = c.iterator(); i.hasNext();) {  
    // here, the collection will check it hasn't been modified (in effort to fail fast)
    String s = i.next();
    if(s.equals("lalala")) {
        // s is removed from the collection through iterator, so the iterator knows the collection changed and can resume the iteration
        i.remove();
    }
}
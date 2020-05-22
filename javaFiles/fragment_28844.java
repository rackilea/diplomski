if(!numCount.containsKey(charAt)){  
    numCount.put(charAt, new ArrayList<>(Arrays.asList(i))); // <-- we store a list containing the first index i
    // numCount.put(charAt, 1);
} else{
    numCount.get(charAt).add(i); // <-- we add to the existing list the index i
    // numCount.put(charAt, numCount.get(charAt)+1);
}
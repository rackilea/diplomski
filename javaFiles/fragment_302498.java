if (receipt.containsKey(i){
    receipt.get(i) += 1; // increment qantity
    // do other stuff to total, taxes etc.
} else { // this is the first time this kind of item is being added
    receipt.put(i, new Integer(1)); // so put it in the map
}
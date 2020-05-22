//this code iterates through all entries (from first, second, third, ... to last)
tree.entrySet().forEach(entry -> {
    key = entry.getKey();
    value = entry.getValue();
    //use key and value to do whatever you need
});
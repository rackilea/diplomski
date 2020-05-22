String getName(int id) { // supposed id is an integer
    return coMap.entrySet()
             .stream()
             .filter(coEntry -> coEntry.getValue().equals(id))
             .map(coEntry -> coEntry.getKey())
             .collect(Collectors.joining()); 
}
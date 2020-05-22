Predicate<T> predicate = (t -> <your predicate here>);
return myMap.keySet()
    .stream()
    .filter(predicate)
    .findAny()
    .map(myMap::get);
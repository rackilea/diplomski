private <T extends SomeSuperClass> int comp(Comparable<T> upper, Comparable<T> lower){
    return upper.compareTo((T) lower);
}

private <T extends SomeSuperClass> int compare (Comparable<T> upper, Comparable<T> lower){
    return comp(upper, lower); 
}
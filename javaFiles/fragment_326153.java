private  <T extends Comparable<T>> boolean  compareAgainstFilters(T val, T filterSmall, T filterGreat) {
    if (!(filterSmall != null && filterSmall.compareTo(val)<=0)) {
        return true;
    } 

    if (!(filterGreat != null && val.compareTo(filterGreat)<=0)) {
        return true;
    }
    return true;
}
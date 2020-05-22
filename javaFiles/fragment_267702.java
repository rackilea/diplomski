if (o1.isDateLastContactNull() && o2.isDateLastContactNull()) {
    // if both null, return comparison of addresses
    return o1.getAddress().compareTo(o2.getAddress());
} else if (o1.isDateLastContactNull()) {
    // if first null, return -1
    return -1;
} else if (o2.isDateLastContactNull()) {
    // if second null, also return -1 ?
    return -1; // should probably be 1 instead
}
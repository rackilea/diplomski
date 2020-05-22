public int compare(...) {
    if (o1.getName() == null && o2.getName() == null) {
        return 0;
    } else if (o1.getName() == null) {
        return 1;
    } else if (o2.getName() == null) {
        return -1;
    } else {
        return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
    }
}
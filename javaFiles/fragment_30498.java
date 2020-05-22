public int compare(Object o1, Object o2) {
    // maybe some null checks here?

    if (o1.getClass().equals(o2.getClass())) {
        // and what if they are not Comparable ?
        return ((Comparable)o1).compareTo((Comparable)o2);
    } else {
        // for example compare by class name alphabetically
        // another idea would be a map with all supported classes,
        // assigning them an order

        return o1.getClass().getName().compareTo(o2.getClass().getName());
    }

}
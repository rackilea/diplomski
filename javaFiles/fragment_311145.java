public void checkAddresses(List<Address> addresses) {
    if (addresses == null) throw new IllegalArgumentException("Address List cannot be null");
    for (Address a : addresses) {
        if (a == null) throw new IllegalArgumentException("Address cannot be null");
    }
}
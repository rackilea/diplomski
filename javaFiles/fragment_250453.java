Address address = null;
for (Address addr : addresses) {
    if ( isBetterThanAlreadyFound(addr, address) ) {
        address = addr;
    }
}


private static boolean isBetterThanAlreadyFound(Address addr, Address alreadyFound) {
    return alreadyFound == null || (addr.isOfDesiredType() && alreadyFound.isNot());
}
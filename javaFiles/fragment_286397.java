boolean evaluate(Address address, AddressTypes... types) {
    for (AddressType type : types) {
        if (address.getTypes().contains(type)) {
            return true;
        }
    }
    return false;
}
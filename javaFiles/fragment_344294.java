if (user1 == null || user2 == null) {
    if (user1 == user2) {
        // both are null
        return 0;
    } else if (user1 == null) {
        return -1;
    }
    // user2 is null
    return 1;
}
if (mType == EnumComparatorObjectType.ENUM_OBJECT_ADDRESS_BOOK_ENTRY) {
    String name1 = user1.getUsername();
    String name2 = user2.getUsername();
    return name1.compareToIgnoreCase(name2);
} else if (mType == EnumComparatorObjectType.ENUM_OBJECT_PRESENCE) {
    EnumPresence p1 = user1.getState();
    EnumPresence p2 = user2.getState();
    return p1.compareTo(p2);
} else {
    throw IllegalArgumentException("Unsupported type: " + mType);
}
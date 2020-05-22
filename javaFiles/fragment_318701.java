@Override
public int compare(User u1, User u2) {
    final int booleanCompare = Boolean.compare(u2.myBooleanField,
                                               u1.myBooleanField);
    if (booleanCompare != 0) {
        return booleanCompare;
    }
    return u1.name.compareTo(u2.name);
}
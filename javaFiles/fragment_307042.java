public boolean ContainsAny (CharSequence keys) {
    for (int i = 0; i < keys.length; i++)
        if (Contains(keys.charAt(i)) return true;

    return false;
}

public boolean ContainsAll (CharSequence keys) {
    for (int i = 0; i < keys.length; i++)
        if (!Contains(keys.charAt(i)) return false;

    return true;
}
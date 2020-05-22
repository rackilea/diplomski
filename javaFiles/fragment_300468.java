VersionValue current_vval = null;
VersionValue new_vval = null;

do {
    current_vval = key_vval_map.get(key);

    VersionValue effectiveVval = current_vval == null ? VersionValue.RESERVED_VERSIONVALUE : current_vval;

    if (effectiveVval.compareTo(vval) < 0) {
        new_vval = vval;
    } else {
        break;
    }
} while (!replace(key, current_vval, new_vval));

...

private boolean replace(Key key, VersionValue current, VersionValue newValue) {
    if (current == null) {
        return key_vval_map.putIfAbsent(key, newValue) == null;
    } else {
        return key_vval_map.replace(key, current, newValue);
    }
}
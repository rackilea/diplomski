for (String val : directory.values()) {
    if (!seen.add(val)) {
        // if add failed, then val was already seen
        repeatedEntries.add(val);
    }
}
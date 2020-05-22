// This is case sensitive
boolean synonymFound = false;
for (String synonym : entry.syns) {
    if (s.contains(synonym)) {
        s = s.replace(synonym, entry.key)
        break;
    }
}
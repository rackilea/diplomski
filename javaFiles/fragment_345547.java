boolean allMatch = true;
for (char  h : collection) {
    if (!condition) {
        allMatch = false;
        break;
    }
}
if (allMatch) {
    x = newX;
}
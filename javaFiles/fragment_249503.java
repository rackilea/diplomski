if (checkM && checkI) {
    newFilter("A|B", 4);
} else if (checkM) {
    newFilter("A", 4);
} else if (checkI) {
    newFilter("B", 4);
} else {
    newFilter("", 4);
}
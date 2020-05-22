if (rowIndex >= dataColLinker.size()) {
    do {
        dataColLinker.add(value);
    } while(rowIndex >= dataColLinker.size());
} else {
    dataColLinker.set(rowIndex, value);
}
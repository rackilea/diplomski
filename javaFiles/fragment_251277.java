private static void setOnlyOne(int index) {
    for (int i = 0; i < listOfBooleans.size(); i++) {
        listOfBooleans.set(i, false);
    }
    listOfBooleans.set(index, true);
}
static int sumRecursive(int index) {
    if (index == testArray.length) {
        return 0;
    }
    return sumRecursive(index + 1) + testArray[index];
}
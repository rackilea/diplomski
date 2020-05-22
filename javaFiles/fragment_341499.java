// low == 4 and high == 4
if (4 < 4) { // false, 4 is not less than 4
    swap(a, 4, findMinIndex(a, 4)); // none of this happens
    selectionSort(a, 4 + 1, 4); // no recursion
}
// finally returns void
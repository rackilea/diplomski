// From TimSort.binarySort
while (left < right) {
    int mid = (left + right) >>> 1;
    if (c.compare(pivot, a[mid]) < 0)  // compares for less than 0.
        right = mid;
    else
        left = mid + 1;
}
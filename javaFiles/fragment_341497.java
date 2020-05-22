// index == 1
minIndex = 2; // we compared 2 and 3 and found that the element at index 2 was smaller
if (data[2] < data[1]) { // is 2 less than 4?
    return 2; // yes, this is returned because the element at index 2 is less than the element at index 1
} else {
    return 1; // false!
}
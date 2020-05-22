int position = Arrays.binarySearch(values, valueToLookFor);
if (position >= 0) {

    // Found it!
    int index = indices[position];

    System.out.println("Value was originally stored in " + index);

} else {

    // Value not found
}
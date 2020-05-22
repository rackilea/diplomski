User lookFor = new User(30, null);
index = Collections.binarySearch(l, lookFor, c);
while (index > 0 && c.compare(lookFor, l[index-1]) == 0) {
    index--;
}
// At this point the index is at the first element of the equal range
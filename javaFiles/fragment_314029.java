for(int i = 0; i < n; ++i) {
    if(list[i] == x) { // an array is 0-indexed
        System.out.println("Found at index: " + i);
        return true;   // return true if found
    }
}
System.out.println("Not found!");
return false;      // here, x has never been found, so return false
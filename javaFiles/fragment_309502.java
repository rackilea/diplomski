// Make sure it's sorted
Collections.sort(arlst, Collections.reverseOrder());

int index=Collections.binarySearch(arlst, "D", Collections.reverseOrder());     

System.out.println(index);  // prints 1
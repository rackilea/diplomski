boolean found = false;
for(int x = 0; x < $myUnsorted.length; x++) {
    if($myUnsorted[x] == $mySearch) {
        found = true;
        System.out.println("Search Value: " + $mySearch + " found at location: " + x + " in the unsorted array");
    }
}
if(!found) {
    System.out.println("Search Value: " + $mySearch + " was not found");
}
array2.clear();
for (Item i : array1) {
     if (.....) {
           //Use copy constructor
           Item newItem = new Item(i)); 
           array2.add(newItem);
     }
}
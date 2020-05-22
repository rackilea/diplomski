List yourList = ...; // Your list
 int removed = 0; // Setup the variable for removal counting

 while (removed < Math.min(secondList.size(), 5)) { // While we still haven't removed 5 entries OR second list size
   yourList.remove(yourList.size() - 1); // Remove the last entry of the list
   removed++; // Increases 'removed' count
 }
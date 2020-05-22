// Why do you need yo swap it in a cycle, thus many times???
  /* Commenting faulty code out
  for (i = 0; i < numElem; ++i) {
     tmpStore = sortArray[i]; // Do swap
     sortArray[i] = sortArray[numElem - 1];
     sortArray[numElem - 1] = tmpStore;
  }
  */

  // A single time should do
  tmpStore = sortArray[0]; // Do swap with the starting end
  sortArray[0] = sortArray[numElem - 1];
  sortArray[numElem - 1] = tmpStore;
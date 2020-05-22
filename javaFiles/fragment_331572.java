double largest = quarterlyArray[0];
for (int k = 1; k < quarterlyArray.length; k++) { // Determines the largest quarterly rainfall.
  if ( quarterlyArray[k] >= largest ) {
    largest = quarterlyArray[k];
  }
}
different = 0;
for (i=0; i<len; i++) {
  if (*a++ != *b++) { // walk through lists using 1 pointer each
    different++;
  }
}
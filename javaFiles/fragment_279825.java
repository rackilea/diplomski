for (int consider = 1; consider < array.length; ++consider) {
  boolean matchfound=false;

  for(int compare=0;compare<outsize;++compare) {
    if(array[consider]==array[compare]) {
      matchfound=true;
      break;
    }

    if(!matchFound) // only add it to the output if not found
      array[outsize++]=array[consider];
}
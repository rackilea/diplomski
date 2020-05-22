public void mainMethod() {

    ...

    for(int i=0; i<(results.length-1); i++) {
      compare(results, i);  
    }
}

private void compare(String[] results, int index) {
   // compare if both values are in the same array
   if(getRowIndex(results[index]) == getRowIndex(results[index+1])) {
         reRoll(results, (index+1)); // reroll if so
         compare(results, index); // revalidate in case it re-rolls to the same array value
   }
}

private void reRoll(String[] results, int index) {
    //TODO
}

private void getRowIndex(...) {
    //TODO
}
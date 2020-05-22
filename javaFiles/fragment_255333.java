for(i = 0; i < NUM_VALS; ++i) {
   if(userValues[i] == matchValue) {
      //numMatches = i;   //WRONG
      numMatches++;     //Correct
   }
}
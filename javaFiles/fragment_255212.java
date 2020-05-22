Object source = evt.getSource();
for (int i = 0; i < buttonArray.length; i++) {
   for (int j = 0; j < buttonArray[i].length; j++) { 
     if (source == buttonArray[i][j]) {
        // the current i and j are your array row and column for the source button
     }
   }
}
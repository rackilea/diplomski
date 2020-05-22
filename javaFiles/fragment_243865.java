if (buttonId == R.id.buttonViewPrevious){
   if (currentBoothArrayIndex < boothArrayList.size() - 1) {
     displayBoothInformation(--currentBoothArrayIndex);
   } 
}else if (buttonId == R.id.buttonViewNext){
   if (currentBoothArrayIndex < boothArrayList.size() - 1) {
     displayBoothInformation(++currentBoothArrayIndex);
   } 
}
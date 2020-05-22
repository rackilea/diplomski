for (int i = x-1; i <= x+1; ++i) {
   for (int j = y-1; j <= y+1; ++j) {
       GameObject item = levelItems[i][j];
       if (item.isBorderObject() && item.isVisible()) 
           return true;
   }
}
return false;
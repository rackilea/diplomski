for (boolean[] bb : array) {
   for (boolean b : bb) {
     if(!b) return false;
   }
}
return true;
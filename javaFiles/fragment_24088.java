for (int i = innerLastIndex; i != 0; i--) {

     innerRotorClockWise[i] = innerRotorClockWise[i-1];

}
innerRotorClockWise[0] = innerOldLast;
int[] rangeTracker = new int[100];
int rangeTrackIndex = 0;
For (int j = 0; j < A.getLength(); j++) {

     if ((A[j] >= 45) && (A[j] <= 55)) {
          rangeTracker[rangeTrackIndex] = A[j];
          rangeTrackIndex++;
}
}
For (int j=0; j < rangeTracker.getLength(); j++) {
     System.out.println(rangeTracker[j]);
}
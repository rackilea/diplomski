for(int i = 0; i < question.length; i++){
  int idx = rand.nextInt((max - min) + 1) + min;
  if (idx == i) {
    i--; 
    continue;
  }
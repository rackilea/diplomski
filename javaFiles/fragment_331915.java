public int makeChocolate(int small, int big, int goal) {
  int ans= -1;


  for(int i = 1; i <= small; i++){
  if(i + (big * 5) == goal){
  ans = i;
  }

  }return ans;
}
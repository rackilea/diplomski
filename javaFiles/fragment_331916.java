public int makeChocolate(int small, int big, int goal) {
  int ans= -1;

 for(int j = 1; j <= big; j++){
 if(j * 5 < goal){
  for(int i = 1; i <= small; i++){
  if(i + (j * 5) == goal){
  ans = i;
  }}}
  else if(j * 5 == goal){
  ans = 0;}
  else{ for(int i = 1; i <= small; i++){
  if(i== goal){
  ans = i;}}}}return ans;
}
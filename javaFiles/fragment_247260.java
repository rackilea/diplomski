int minValue = 1000000; //
for(int i =0; i< player.length; i++){
  if(player[i] < minValue){
    minValue = player[i];
  }
}
int j =0;
for(int i =0; i< player.length; i++){
  if(player[i]==minValue){
    min[j]=i;
    j++;
  }
}
int highest = 0;
int lowest = 0;
for(int i = 0; i<x.length; i++){
  if(x[i] > highest){
    highest = x[i];
  }
  if(x[i] < lowest){
    lowest = x[i];
  }
  if(i == 0){
    highest = x[i];
    lowest = x[i];  
  }
}
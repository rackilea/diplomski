boolean firstClassFull = true;
for(int i=0; i<5; i++){
   if(seats[i] == false){
      firstClassFull = false;
      seats[i] = true;
      break;
   }
}
if(n<=1)){
   if(n==0){
     return true;
   }
   else{
     return false;
   }
}
else{
  if(even(n-1)){
    return false;
  }
  else{
   return true;
  }
}
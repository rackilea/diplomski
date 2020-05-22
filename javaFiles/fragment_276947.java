for(int i = 0; i < a.length; i++){
   char c = a[i]; //get current char
   if(c != 'x' && c != 'y'){ //check if it is a x or y
      a[i] = 'q' //replace current char
   }
}
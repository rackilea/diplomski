int index = -1;
 double max = 0;

 for(int i = 0; i < 10; i++){
   double total = (studentMarksArray[i][0]*studentMarksArray[i][1]*studentMarksArray[i][2])/3;

   if(Math.max(max, total) == total) {
     index = i;
     max = total;
   }
 }
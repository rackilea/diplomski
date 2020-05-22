private String timeTransfer(){

     minutes = counter/6000;
     seconds = (counter % 6000) /100 ;
     milliseconds = counter % 100;
     return minutes + " : " + seconds + " : " + milliseconds;
 }
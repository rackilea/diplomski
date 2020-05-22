int newarray[] = new int[highscore.length+1];
 for(int i=0, j=0; i<highscore.length+1; i++){
     if(i == Zahl){
          newarray[i] = Stelle;
     }
     else{
          newarray[i] = highscore[j++];
     }
 }
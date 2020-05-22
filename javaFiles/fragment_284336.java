boolean paused = false;

void draw(){
   if(paused){
      //draw paused screen
   }
   else{
      //draw your program
   }
}

void mouseClicked(){
   paused = !paused;
}
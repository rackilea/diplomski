private boolean b = false;   
void mouseClicked(){
   if(b == false){
      print("clicked1");
   } else {
      print("clicked2");
   }
}

void draw(){
  if(frameRate>=1000){
     b = true;
  } else {
     b = false;
  }
  exit(); 
}
double counter = 0;

void render(float delta){

   if (counter >= 5.0){
       counter = 0.0;
       fireUpYourTimelyProcessHere();
   } else {
       counter = counter + delta;
   }

  ... 

   // other rendering stuff

}
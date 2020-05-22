class Physics{
   Vec2 centre;
   Rec hitbox;
   Vec2 speed;
   Vec2 acc;
   ...

   public void update(){ //critical method
       centre.doThings();
       hitbox.doThings();
       etc...
   }

}
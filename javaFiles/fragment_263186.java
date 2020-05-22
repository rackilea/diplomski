public boolean onTouch(View v, MotionEvent event)
{
    while(event.getAction()!=MotionEvent.ACTION_CANCEL) // or here measure the pressure applied on the screen surface
    { 
       if(event.getY() <= knifeY)
       {
        knifeDOwn=false; // keep the knife down 
        point--; 
        knife = BitmapFactory.decodeResource(getResources(),R.drawable.bloddyknife); // 
         //maybe here you might stop the pointers collecting with using event.setAction(MotionEvent.ACTION_CANCEL) (or ACTION_UP) to exit the while loop, i dont know your idea for it, at this point i'm just guessing, but you still need to change the action of the event at anypoint at this code to exit the while loop.
       }
  }
  return true;
}
// You'd probably need to store this variable class-wide,
// so you can control when the user has tapped for the first or second time
boolean playing = false;

@Override
public boolean onTouch(View v, MotionEvent event) 
{
    if(event.getAction() == MotionEvent.ACTION_DOWN) 
    {
        if(!playing)
        {
            playing = true;
            new Thread(
              new Runnable() {
                public void run() {
                  while(playing)
                  {
                    //do something here
                  }
                }
              }
            ).start();
        }
        else if(playing)
        {
            playing = false;
            // As you're controlling the playing value in the Thread,
            // setting it here to false would mean that your thread stops too.
        }
    }
    return false;
}
Boolean canClick = true; //make global variable
   Handler  myHandler = new Handler();

@Override
public void onClick(View v)
{
    if (canClick)
    {

       canClick= false;   //lock the image
       myHandler.postDelayed(mMyRunnable, 2000);

       //perform  your action here

    }

}

/* give some delay..*/
    private Runnable mMyRunnable = new Runnable()
    {
        @Override
        public void run()
        {   

         canClick = true;
         myHandler.removeMessages(0);
        }
     };


Instead of sleeping in 2 seconds, I use some task like doSomeThing() method (has accessed UI thread), and I don't know when it completed. So how can I try your way?
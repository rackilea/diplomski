@Override
public void run() 
 {
    //update screen ever 1000ms
    mEmulatorView.invalidate();

     if(yourCondition==true){ //put here a condition that the runnable only starts if this is true
//should check data received every 1000ms
for(int i = 0; i < dataReceived.length(); i++)
    {           
        if(dataReceived.charAt(i) == '>')
            {

                 Log.d(TAG, "found >");
            }

        if(dataReceived.charAt(i) == '#')
            {

                 Log.d(TAG, "found #");     
            }
    }
    viewHandler.postDelayed(updateView, 1000);
    }
   }

  };
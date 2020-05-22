//Add the following line in the code before your setOnTouchListener()
MediaPlayer mp;

public boolean onTouch(View v, MotionEvent event) { 

    if (v.getId() == R.id.clash){ 

        switch (event.getAction()) { 

        case MotionEvent.ACTION_DOWN: 
            mp = MediaPlayer.create(getBaseContext(), R.raw.clash); 
            mp.setLooping(true); 
            mp.start(); 
            break; 

        case MotionEvent.ACTION_UP: 
            if(mp != null) 
            {
                mp.pause(); 
                mp.release();
            }
            break; 
        } 
    } 
} 

// I'm assuming this was from the onTouchListener()? -> });
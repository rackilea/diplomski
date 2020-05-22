@Override
public boolean onKeyDown(int KeyCode, KeyEvent event){

    boolean handled = false;


    if(KeyCode == KeyEvent.KEYCODE_CHANNEL_DOWN){
        Log.i("KeyEvent","Channel down button pressed");//for debugging, to be printed on logcat
        handled=true;

        //do something
    }

    else if(KeyCode == KeyEvent.KEYCODE_CHANNEL_UP){
        Log.i("KeyEvent","Channel up button pressed");//for debugging, to be printed on logcat
        handled=true;

        //do something
    }


    if(handled){

        return handled;
    }

    //return super.onKeyDown() to attend unattended KeyEvent
    else{
        return super.onKeyDown(KeyCode, event);
    }
}
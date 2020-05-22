public boolean onTouch(View v, MotionEvent event) {
            // TODO Auto-generated method stub
            if(firstTap){
                thisTime = SystemClock.uptimeMillis();
                firstTap = false;
            }else{
                prevTime = thisTime;
                thisTime = SystemClock.uptimeMillis();

                //Check that thisTime is greater than prevTime
                //just incase system clock reset to zero
                if(thisTime > prevTime){

                    //Check if times are within our max delay
                    if((thisTime - prevTime) <= DOUBLE_CLICK_MAX_DELAY){

                        //We have detected a double tap!
                        Toast.makeText(DoubleTapActivity.this, "DOUBLE TAP DETECTED!!!", Toast.LENGTH_LONG).show();
                        //PUT YOUR LOGIC HERE!!!!

                    }else{
                        //Otherwise Reset firstTap
                        firstTap = true;
                    }
                }else{
                    firstTap = true;
                }
            }
            return false;
        }
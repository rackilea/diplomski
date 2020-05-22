//initialize the Gesture Detector  
        gd = new GestureDetector(this);  

        //set the on Double tap listener  
        gd.setOnDoubleTapListener(new OnDoubleTapListener()  
        {  
            @Override  
            public boolean onDoubleTap(MotionEvent e)  
            {  
                //set text color to green  
                tvTap.setTextColor(0xff00ff00);  
                //print a confirmation message  
                tvTap.setText("The screen has been double tapped.");  
                return false;  
            }  

            @Override  
            public boolean onDoubleTapEvent(MotionEvent e)  
            {  
                //if the second tap hadn't been released and it's being moved  
                if(e.getAction() == MotionEvent.ACTION_MOVE)  
                {  
                    //set text to blue  
                    tvTapEvent.setTextColor(0xff0000ff);  
                    //print a confirmation message and the position  
                    tvTapEvent.setText("Double tap with movement. Position:\n"  
                            + "X:" + Float.toString(e.getRawX()) +  
                            "\nY: " + Float.toString(e.getRawY()));  
                }  
                else if(e.getAction() == MotionEvent.ACTION_UP)//user released the screen  
                {  
                    tvTapEvent.setText("");  
                }  
                return false;  
            }  

            @Override  
            public boolean onSingleTapConfirmed(MotionEvent e)  
            {  
                //set text color to red  
                tvTap.setTextColor(0xffff0000);  
                //print a confirmation message and the tap position  
                tvTap.setText("Double tap failed. Please try again.");  
                return false;  
            }  
        });
int pressedx,pressedy;
    int viewMariginX,viewMariginY;  

@Override
public boolean onTouch(View v, MotionEvent event) {

    int currentx=(int) event.getRawX();
    int currenty=(int) event.getRawY();


//get Layout Param of your cardView 

    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) v.getLayoutParams();

    switch(event.getAction())
    {

    case MotionEvent.ACTION_DOWN :

        pressedx=currentx;
        pressedy=currenty;

        viewMariginX=layoutParams.leftMargin;
        viewMariginY=layoutParams.topMargin;
        break;


    case MotionEvent.ACTION_MOVE : 

        int diffx=currentx-pressedx;
        int diffy=currenty-pressedy;

        int marginx=viewMariginX+diffx;
        int marginy=viewMariginY+diffy;


        layoutParams.leftMargin=marginx;
        layoutParams.topMargin=marginy;     
        v.setLayoutParams(layoutParams);          
        break;

    case MotionEvent.ACTION_UP : 

        int diffx2=currentx-pressedx;
        int diffy2=currenty-pressedy;

        int marginx2=viewMariginX+diffx2;
        int marginy2=viewMariginY+diffy2;


        layoutParams.leftMargin=marginx2;
        layoutParams.topMargin=marginy2;            
        v.setLayoutParams(layoutParams);    
        break;
    }

    return true;
}
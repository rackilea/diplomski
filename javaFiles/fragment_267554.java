@Override
   boolean onTouch(View view, MotionEvent motionEvent) {
         case R.id.send:
            switch(motionEvent.getAction()){
                case MotionEvent.ACTION_DOWN:
                    //when the user has pressed the button
                    //do the needful here
                    break;
                case MotionEvent.ACTION_UP:
                    //when the user releases the button
                    //do the needful here
                    break;
            }`enter code here`
            break;
     }
     return true;
 }
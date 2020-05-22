boolean hasStartPoint= false;
        int startPointX =0;
        int startPointY=0;
        switch(event.getAction()){
            float eventX = event.getX();
            float eventY = event.getY();

            case MotionEvent.ACTION_DOWN:
                if(hasStartPoint) {
                    path.lineTo(eventX, eventY);
                }
                hasStartPoint=false;
                break;

            case MotionEvent.ACTION_MOVE:

                break;

            case MotionEvent.ACTION_UP:

                if(!hasStartPoint) {
                    startPointX = eventX;
                    startPointY = eventY;
                }
                hasStartPoint = true;

                break;




            default:
                return false;
        }
@Override
    public void onRawDrawingTouchPointMoveReceived(TouchPoint touchPoint) {
        Log.d(TAG, "onRawDrawingTouchPointMoveReceived");
        Log.d(TAG,touchPoint.getX() +", " +touchPoint.getY());
        countRec++;
        countRec = countRec % INTERVAL;
        if (!cbRender.isChecked() && countRec == INTERVAL - 1 ){
            drawRect(touchPoint);
        }
        Log.d(TAG,"countRec = " + countRec);

        canva.drawLine(startPoint.x, startPoint.y, touchPoint.x, touchPoint.y, paint);
        startPoint=touchPoint;
    }
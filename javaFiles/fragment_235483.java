case MotionEvent.ACTION_DOWN:
mPaint.setStrokeWidth(25);
            mPaint.setXfermode(new PorterDuffXfermode(
                    PorterDuff.Mode.CLEAR));
            mCanvas.drawCircle(x, y, 10, mPaint);
            isErase = true;
            invalidate();
        }
        touch_start(x, y);
        invalidate();
        break;
case MotionEvent.ACTION_MOVE:   
        if(isErase)
        {
            mCanvas.drawCircle(x, y, 20, mPaint);
        }
        else{
            touch_move(x, y);
        }invalidate();
        break;
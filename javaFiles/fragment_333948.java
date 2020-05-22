case MotionEvent.ACTION_MOVE:
    if (!ScaleDetector.isInProgress()) {

        speedx = (event.getX() - downCorx);
        speedy = (event.getY() - downCory);

        // update your current position. So when ACTION_MOVE is triggered again, you actually calculate only the speed between the current and last event of ACTION_MOVE
        downCorx = event.getX();
        downCory = event.getY();

        matrix.postTranslate(speedx, speedy);
        Log.e("000", speedx + "| " + speedy + "! ");

    }
    this.invalidate();
    break;
switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                playerX = x;
                playerY = y;
                break;                      // any reason you do not want this?
            case MotionEvent.ACTION_UP:
                Playing = false;
            }
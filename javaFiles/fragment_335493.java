glSurfaceView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event != null) {
                // Convert touch coordinates into normalized device
                // coordinates, keeping in mind that Android's Y
                // coordinates are inverted.
                final float normalizedX =
                (event.getX() / (float) v.getWidth()) * 2 - 1;
                //final float normalizedY = -((event.getY() / (float) v.getHeight()) * 2 - 1);//commented to kill z axis
                //final float normalizedY;

                final float scrnx =event.getX();
                final float scrny =event.getY();

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    normalizedY = -((event.getY() / (float) v.getHeight()) * 2 - 1);
                    glSurfaceView.queueEvent(new Runnable() {
                        @Override
                        public void run() {
                            airHockeyRenderer.handleTouchPress(
                            normalizedX, normalizedY);
                        }
                    });
                } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    normalizedY = -((event.getY() / (float) v.getHeight()) * 2 - 1);
                    glSurfaceView.queueEvent(new Runnable() {
                        @Override
                        public void run() {
                            airHockeyRenderer.handleTouchDrag(
                            normalizedX, normalizedY, scrnx, scrny);
                        }
                    });
                }
                    return true;
                } else {
                    return false;
                }
            }
        });
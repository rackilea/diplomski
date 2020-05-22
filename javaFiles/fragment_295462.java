super.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        buttonContent.startAnimation(rectMoveDown);
                        colorDown.start();
                        return false;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        buttonContent.startAnimation(rectMoveUp);
                        colorUp.start();
                        return false;
                }
                return false;
            }
        });
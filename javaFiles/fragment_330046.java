imageViewPad.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent event) {

            // deactivate the moving of the parent element when the touchpad is touch
            imageViewPad.getParent().requestDisallowInterceptTouchEvent(true);

            switch (event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                {
                    touchpadOnActionDown(event);
                    break;
                }

                case MotionEvent.ACTION_MOVE:
                {
                    touchpadOnActionMove(event);
                    break;
                }

                case MotionEvent.ACTION_UP:
                {
                    touchpadOnActionUp(event);
                    break;
                }

                default:
                    break;
            }
            return true;
        }
    });
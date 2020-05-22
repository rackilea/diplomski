llBackground.setOnTouchListener(new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                v.setBackground(view.getResources().getDrawable(R.drawable.border_clicked));
                break;
            case MotionEvent.ACTION_UP:
                v.setBackground(view.getResources().getDrawable(R.drawable.border));
                v.performClick();
                break;
            case MotionEvent.ACTION_CANCEL:
                v.setBackground(view.getResources().getDrawable(R.drawable.border));
                break;
            }
            return false;
        }
    });
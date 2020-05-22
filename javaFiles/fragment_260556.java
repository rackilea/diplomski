button.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mCamera.setPreviewCallback(previewCallback);
                buttonPressed = true;
                button.post(buttonPressedRunnable);
                break;
            case MotionEvent.ACTION_UP:
                buttonPressed = false;
                break;
        }
        return false;
    }
});
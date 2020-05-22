imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            int viewWidth = imageView.getWidth();
            int viewHeight = imageView.getHeight();
            if (viewWidth > 0 && viewHeight > 0) {
                //do some stuff here
            }
            //we remove this listener to not being notified every time the view
            //changes it's size. 
            //But if you need this info every time, just remove the last line
            imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    });
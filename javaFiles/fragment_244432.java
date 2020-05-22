new Thread(new Runnable() {
        @Override
        public void run() {
            System.err.println("getMeasuredHeight:" + parentView.getMeasuredHeight());
            System.err.println("getMeasuredWidth:" + parentView.getMeasuredWidth());
            parentView.removeView(view);
        }
    }).start();
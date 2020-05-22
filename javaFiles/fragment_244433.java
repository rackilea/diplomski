new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println("getMeasuredHeight:" + parentView.getMeasuredHeight());
            System.err.println("getMeasuredWidth:" + parentView.getMeasuredWidth());
            parentView.removeView(view);
        }
    }).start();
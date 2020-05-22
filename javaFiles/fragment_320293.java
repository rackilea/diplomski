yourScrollView.post(
    new Runnable() {
        @Override
        public void run() {
            yourScrollView.scrollTo(desiredPositionX, desiredPositionY);
        } 
    }
);
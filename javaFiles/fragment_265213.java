// use post - runnable to get height of view before it's actually shown
    level3Frame.post( new Runnable() {
        @Override
        public void run() {
            final int halfMargin = level3Frame.getHeight()/2;
            <snip>
        }
    });
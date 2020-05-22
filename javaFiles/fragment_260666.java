ActivitySwipeDetector activitySwipeDetector = new ActivitySwipeDetector(
        this,
        new SwipeCallback() {
            //handle the swipes
            @Override
            public void onRightSwipe() {}

            @Override
            public void onLeftSwipe() {}

            @Override
            public void onUpSwipe() {}

            @Override
            public void onDownSwipe() {}
        }
);
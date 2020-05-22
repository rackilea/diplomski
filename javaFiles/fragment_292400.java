public class NonSwipeableViewPager extends ViewPager {

        boolean enabled = false;

        public NonSwipeableViewPager(Context context) {
            super(context);
            setMyScroller();
        }

        public NonSwipeableViewPager(Context context, AttributeSet attrs) {
            super(context, attrs);
            setMyScroller();
        }

        @Override

        public boolean onInterceptTouchEvent(MotionEvent event) {
            if (this.enabled) {
                return false;
            }
            return super.onInterceptTouchEvent(event);

        }

        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (this.enabled) {
                return false;
            }
            return super.onTouchEvent(event);

        }

        //down one is added for smooth scrolling

        private void setMyScroller() {
            try {
                Class<?> viewpager = ViewPager.class;
                Field scroller = viewpager.getDeclaredField("mScroller");
                scroller.setAccessible(true);
                scroller.set(this, new MyScroller(getContext()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public class MyScroller extends Scroller {
            public MyScroller(Context context) {
                super(context, new DecelerateInterpolator());
            }

            @Override
            public void startScroll(int startX, int startY, int dx, int dy, int duration) {
                super.startScroll(startX, startY, dx, dy, 350 /*1 secs*/);
            }
        }

        public void setPagingDisabled(boolean enabled) {
            this.enabled = enabled;
        }
    }

Then on my linechart I used onChartGestureStart and onChartGestureEnd to enable or disable the pageview:

    @Override
        public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
            nonSwipeableViewPager.setPagingDisabled(true);
        }

        @Override
        public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
            nonSwipeableViewPager.setPagingDisabled(false);
        }
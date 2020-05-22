barChart.setOnChartGestureListener(new OnChartGestureListener() {
        @Override
        public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
            horizontalScrollView.requestDisallowInterceptTouchEvent(true);
        }

        @Override
        public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
            horizontalScrollView.requestDisallowInterceptTouchEvent(false);
        }

        //.....//

        @Override
        public void onChartTranslate(MotionEvent me, float dX, float dY) {
            Log.i("GESTURE", "onChartTranslate");
            if(barChart.getLowestVisibleX() == barChart.getXAxis().getAxisMinimum() || barChart.getHighestVisibleX() == barChart.getXAxis().getAxisMaximum()) {
                horizontalScrollView.requestDisallowInterceptTouchEvent(false);
            } else {
                horizontalScrollView.requestDisallowInterceptTouchEvent(true);
            }
        }
    });
conSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Calendar cal = Calendar.getInstance();
            //subtracting a day
            cal.add(Calendar.DATE, numberToSubtract);
            numberToSubtract--;
            SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
            String day = s.format(new Date(cal.getTimeInMillis()));

            loadMoreConnections(day);
        }
    });
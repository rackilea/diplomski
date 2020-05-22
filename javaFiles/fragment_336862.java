ScrollView scrollView = (ScrollView) findViewById(R.id.scroll_view);
scrollView.postDelayed(new Runnable() {
     public void run() {
          scrollView.scrollTo(0, (int)view.getY());
     }
}, 100);
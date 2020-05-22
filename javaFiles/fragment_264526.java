setOnScrollListener(new OnScrollListener(){
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
          // TODO Auto-generated method stub
         // Some code that need to be applied simultaneous with scroll event
        }
        public void onScrollStateChanged(AbsListView view, int scrollState) {
          // TODO Auto-generated method stub
          if(scrollState == 0) 
         // Scroll state 0 denotes scrolling is stopped.
        }
      });
    }
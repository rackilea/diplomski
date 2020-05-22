static boolean userScrolled = false;

        androidGridView.setOnScrollListener(new AbsListView.OnScrollListener(){
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
            {
                if(userScrolled == true && (firstVisibleItem + visibleItemCount >= totalItemCount)){
                    EditText rl1 = (EditText) findViewById(R.id.editText);
                    new SearchTask().execute(rl1.getText().toString());
                }
            }

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState){
                if(scrollState == OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    userScrolled = true;
                }   
            }
        });
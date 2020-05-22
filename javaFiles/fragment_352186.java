EditText edittext = (EditText) findViewById(R.id.edittext1<your unique ID>);


    edittext.setOnEditorActionListener(new OnEditorActionListener() {        
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if(actionId==EditorInfo.IME_ACTION_DONE){
                //Clear focus here from edittext
                 edittext.setCursorVisible(false);
            }
            return false;
        }
    });

    edittext.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                edittext.setCursorVisible(true);
                return false;
            }
    });
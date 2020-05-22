getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    getSupportActionBar().setCustomView(R.layout.search_layout);

    search = (EditText) getSupportActionBar().getCustomView().
            findViewById(R.id.searchfield);

    search.setOnEditorActionListener(new EditText.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId,
                                      KeyEvent event) {
            return true;
        }
    });

    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM
            | getSupportActionBar().DISPLAY_SHOW_HOME);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
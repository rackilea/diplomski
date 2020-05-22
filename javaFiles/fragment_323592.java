View dummyView = findViewById(R.id.dummy_view);
dummyView .setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dummyView .performLongClick();
        }
    });